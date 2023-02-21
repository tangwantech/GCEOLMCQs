package com.example.gceolmcq.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.activities.OnRequestToGoToResultListener
import com.example.gceolmcq.R
import com.example.gceolmcq.ResourceImages
import com.example.gceolmcq.datamodels.SectionDataModel
import com.example.gceolmcq.viewmodels.SectionFragmentViewModel

private const val SECTION_DATA = "Section data"
private const val SECTION_INDEX = "Section index"
class SectionFragment : Fragment(), OnClickListener {
    private lateinit var onRequestToGoToResultListener: OnRequestToGoToResultListener

    private lateinit var sectionFragmentViewModel: SectionFragmentViewModel

    private lateinit var svQuestion: ScrollView

    private lateinit var tvTimer: TextView
    private lateinit var tvCurrentQuestionNumberOfTotal: TextView

    private lateinit var btnNextQuestion: Button
    private lateinit var btnResult: Button

    private lateinit var imageLo: CardView
    private lateinit var twoStatementLo: LinearLayout
    private lateinit var nonSelectableOptionsLo: LinearLayout

    private lateinit var tvQuestion: TextView
    private lateinit var questionLayout: LinearLayout

    private lateinit var imageView: AppCompatImageView

    private lateinit var tvFirstStatement: TextView
    private lateinit var tvSecondStatement: TextView
    private val twoStatements: ArrayList<TextView> = ArrayList()

    private lateinit var tvNonSelectableOption1: TextView
    private lateinit var tvNonSelectableOption2: TextView
    private lateinit var tvNonSelectableOption3: TextView
    private val nonSelectableOptions: ArrayList<TextView> = ArrayList()


    private lateinit var tvSelectableOption1: TextView
    private lateinit var tvSelectableOption2: TextView
    private lateinit var tvSelectableOption3: TextView
    private lateinit var tvSelectableOption4: TextView
    private val selectableOptions: ArrayList<TextView> = ArrayList()


    private lateinit var layoutOption1: LinearLayout
    private lateinit var layoutOption2: LinearLayout
    private lateinit var layoutOption3: LinearLayout
    private lateinit var layoutOption4: LinearLayout
    private val optionsLayouts: ArrayList<LinearLayout> = ArrayList()

    private var fadeInOut: Animation? = null
    private var fadeTransition: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sectionFragmentViewModel = ViewModelProvider(this)[SectionFragmentViewModel::class.java]
        sectionFragmentViewModel.setSectionData(requireArguments().getSerializable(SECTION_DATA) as SectionDataModel)
        sectionFragmentViewModel.setSectionIndex(requireArguments().getInt(SECTION_INDEX))

        fadeInOut = AnimationUtils.loadAnimation(requireContext(), R.anim.cross_fade)
        fadeTransition = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_transition)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnRequestToGoToResultListener){
            onRequestToGoToResultListener = context
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_section, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewsFromLayout(view)

        startTimer()
        sectionFragmentViewModel.getTimeRemaining().observe(viewLifecycleOwner, Observer {
            tvTimer.text =
                "${it.minute.toString().padStart(2, '0')}:${it.second.toString().padStart(2, '0')}"

        })

        sectionFragmentViewModel.getIsTimeAlmostOut().observe(viewLifecycleOwner, Observer {
            if(it){
//                tvTimer.setTextColor(requireContext().resources.getColor(R.color.color_accent))
                tvTimer.startAnimation(fadeInOut)
            }

        })

        sectionFragmentViewModel.getIsTimeOut().observe(viewLifecycleOwner, Observer {
            if(it){
                val alertDialog = AlertDialog.Builder(requireContext())
                alertDialog.apply {
                    setMessage("Timeout")
                    setPositiveButton("Ok") { _,_ ->
                        onRequestToGoToResultListener.onRequestToGoToResult(sectionFragmentViewModel.getSectionResultData())
                    }
                    setCancelable(false)
                }.create().show()
                disableSelectableOptions()
                btnResult.isEnabled = true
                btnNextQuestion.isEnabled = false
            }

        })

        btnNextQuestion.setOnClickListener(this)
        btnResult.setOnClickListener(this)

        sectionFragmentViewModel.getQuestionIndex()
            .observe(viewLifecycleOwner, Observer { questionIndex ->
//                svQuestion.startAnimation(fadeInOut)
                setAnimationOnQuestionViewItems()

                tvCurrentQuestionNumberOfTotal.text =
                    "Question ${questionIndex + 1} of ${sectionFragmentViewModel.getNumberOfQuestionsInSection()}"

                if (questionIndex + 1 == sectionFragmentViewModel.getNumberOfQuestionsInSection()) {
                    btnNextQuestion.isEnabled = false
                }

                val questionData = sectionFragmentViewModel.getQuestion()

                if (questionData.question == null) {

                    questionLayout.visibility = View.GONE
                } else {
                    tvQuestion.text = questionData.question
                }

                if (questionData.image == null) {
                    imageLo.visibility = View.GONE
                } else {
//
                    imageLo.visibility = View.VISIBLE
                    imageView.setImageResource(ResourceImages.images[questionData.image]!!)

//                    println(questionData.image)

                }

                if (questionData.twoStatements == null) {
                    twoStatementLo.visibility = View.GONE

                } else {
                    questionData.twoStatements.forEachIndexed { index, s ->
                        twoStatements[index].text = s
                    }
                }

                if (questionData.nonSelectableOptions == null) {
                    nonSelectableOptionsLo.visibility = View.GONE
                } else {
                    questionData.nonSelectableOptions.forEachIndexed { index, s ->
                        nonSelectableOptions[index].text = s
                    }
                }

                questionData.selectableOptions.forEachIndexed { index, s ->
                    selectableOptions[index].text = "${sectionFragmentViewModel.getLetters()[index]}. $s"
                }

                sectionFragmentViewModel.getIsQuestionAnswered()
                    .observe(viewLifecycleOwner, Observer { isQuestionAnswered ->
                        when (isQuestionAnswered) {
                            true -> {
                                btnNextQuestion.isEnabled = true
                                if (questionIndex + 1 == sectionFragmentViewModel.getNumberOfQuestionsInSection()) {
                                    btnNextQuestion.isEnabled = false
                                }
                            }
                            else -> {
                                btnNextQuestion.isEnabled = false
                            }
                        }
                    })


            })

        sectionFragmentViewModel.getNumberOfQuestionsAnswered()
            .observe(viewLifecycleOwner, Observer {
                if (it == sectionFragmentViewModel.getNumberOfQuestionsInSection()) {
                    btnResult.isEnabled = true
                }
            })
    }

    private fun startTimer() {
        sectionFragmentViewModel.startTimer()
    }

    private fun nextQuestion() {
        resetSelectedQuestionOptionBackground()
        sectionFragmentViewModel.incrementQuestionIndex()

    }



    private fun getViewsFromLayout(view: View) {

        svQuestion = view.findViewById(R.id.svQuestion)
        tvTimer = view.findViewById(R.id.tvTimer)

        tvCurrentQuestionNumberOfTotal = view.findViewById(R.id.tvCurrentQuestionOfTotal)

        btnResult = view.findViewById(R.id.btnResult)
        btnNextQuestion = view.findViewById(R.id.btnNext)

        questionLayout = view.findViewById(R.id.questionLayout)
        imageLo = view.findViewById(R.id.imageCardLayout)
        twoStatementLo = view.findViewById(R.id.twoStatementsLayout)
        nonSelectableOptionsLo = view.findViewById(R.id.nonSelectableOptionsLayout)

        tvQuestion = view.findViewById(R.id.tvQuestion)
        imageView = view.findViewById(R.id.imgView)
        tvFirstStatement = view.findViewById(R.id.tvFirstStatement)
        tvSecondStatement = view.findViewById(R.id.tvSecondStatement)
        twoStatements.add(tvFirstStatement)
        twoStatements.add(tvSecondStatement)

        tvNonSelectableOption1 = view.findViewById(R.id.tvNonSelectableOption1)
        tvNonSelectableOption2 = view.findViewById(R.id.tvNonSelectableOption2)
        tvNonSelectableOption3 = view.findViewById(R.id.tvNonSelectableOption3)
        nonSelectableOptions.add(tvNonSelectableOption1)
        nonSelectableOptions.add(tvNonSelectableOption2)
        nonSelectableOptions.add(tvNonSelectableOption3)

        tvSelectableOption1 = view.findViewById(R.id.tvSelectableOption1)
        tvSelectableOption2 = view.findViewById(R.id.tvSelectableOption2)
        tvSelectableOption3 = view.findViewById(R.id.tvSelectableOption3)
        tvSelectableOption4 = view.findViewById(R.id.tvSelectableOption4)
        selectableOptions.add(tvSelectableOption1)
        selectableOptions.add(tvSelectableOption2)
        selectableOptions.add(tvSelectableOption3)
        selectableOptions.add(tvSelectableOption4)

        layoutOption1 = view.findViewById(R.id.layoutOption1)
        layoutOption1.setOnClickListener(this)
        layoutOption2 = view.findViewById(R.id.layoutOption2)
        layoutOption2.setOnClickListener(this)

        layoutOption3 = view.findViewById(R.id.layoutOption3)
        layoutOption3.setOnClickListener(this)

        layoutOption4 = view.findViewById(R.id.layoutOption4)
        layoutOption4.setOnClickListener(this)
        optionsLayouts.add(layoutOption1)
        optionsLayouts.add(layoutOption2)
        optionsLayouts.add(layoutOption3)
        optionsLayouts.add(layoutOption4)

    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = sectionFragmentViewModel.getSectionTitle()
    }

    private fun setAnimationOnQuestionViewItems(){
        svQuestion.startAnimation(fadeTransition)

    }

    companion object {

        @JvmStatic
        fun newInstance(sectionIndex: Int, sectionData: SectionDataModel): Fragment {
            val bundle = Bundle().apply {
                putSerializable(SECTION_DATA, sectionData)
                putInt(SECTION_INDEX, sectionIndex)
            }
            val sectionFragment = SectionFragment()
            sectionFragment.arguments = bundle

            return sectionFragment
        }
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btnNext -> {
                nextQuestion()
            }
            R.id.btnResult -> {

                onRequestToGoToResultListener.onRequestToGoToResult(sectionFragmentViewModel.getSectionResultData())
            }
            R.id.layoutOption1, R.id.layoutOption2, R.id.layoutOption3, R.id.layoutOption4 -> {
                when (p0.id) {
                    R.id.layoutOption1 -> {
                        updateOptionSelected(0)
                    }
                    R.id.layoutOption2 -> {
                        updateOptionSelected(1)
                    }
                    R.id.layoutOption3 -> {
                        updateOptionSelected(2)
                    }
                    R.id.layoutOption4 -> {
                        updateOptionSelected(3)
                    }
                }
            }
        }
    }

    private fun disableSelectableOptions(){
        optionsLayouts.forEach {
            it.isEnabled = false
        }

    }

    private fun updateOptionSelected(optionSelectedIndex: Int) {
        sectionFragmentViewModel.updateUserSelection(optionSelectedIndex)
        changeSelectedQuestionOptionBackground(optionSelectedIndex)

    }

    private fun changeSelectedQuestionOptionBackground(optionSelectedIndex: Int) {

        optionsLayouts[optionSelectedIndex].setBackgroundColor(
            requireContext().resources.getColor(R.color.color_accent)
        )
        sectionFragmentViewModel.getIndexPreviousAndCurrentItemOfQuestion().indexPreviousItem?.let {
            optionsLayouts[sectionFragmentViewModel.getIndexPreviousAndCurrentItemOfQuestion().indexPreviousItem!!].setBackgroundColor(
                requireContext().resources.getColor(R.color.white)
            )
        }
    }

    private fun resetSelectedQuestionOptionBackground() {
        sectionFragmentViewModel.getIndexPreviousAndCurrentItemOfQuestion().indexCurrentItem?.let {
            optionsLayouts[sectionFragmentViewModel.getIndexPreviousAndCurrentItemOfQuestion().indexCurrentItem!!].setBackgroundColor(
                requireContext().resources.getColor(R.color.white)
            )

        }
    }

}
