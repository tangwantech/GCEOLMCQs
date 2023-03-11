package com.example.gceolmcq.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.*
import com.example.gceolmcq.activities.*
import com.example.gceolmcq.datamodels.SectionResultData
import com.example.gceolmcq.viewmodels.SectionResultFragmentViewModel

private const val SECTION_RESULT_DATA = "Section Result data"
private const val MINIMUM_PERCENTAGE = 40

class SectionResultFragment : Fragment() {

    private lateinit var sectionResultFragmentViewModel: SectionResultFragmentViewModel
    private lateinit var onRetrySectionListener: OnRetrySectionListener
    private lateinit var onGetNumberOfSectionsListener: OnGetNumberOfSectionsListener
    private lateinit var onNextSectionListener: OnNextSectionListener
    private lateinit var onGotoSectionCorrectionListener: OnGotoSectionCorrectionListener

    private lateinit var onIsSectionAnsweredListener: OnIsSectionAnsweredListener
    private lateinit var onPaperScoreListener: OnPaperScoreListener
    private lateinit var onCheckPackageExpiredListener: OnCheckPackageExpiredListener



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sectionResultFragmentViewModel =
            ViewModelProvider(this)[SectionResultFragmentViewModel::class.java]
        sectionResultFragmentViewModel.setResultData(
            requireArguments().getSerializable(
                SECTION_RESULT_DATA
            ) as SectionResultData
        )

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnRetrySectionListener) {
            onRetrySectionListener = context
        }
        if (context is OnGetNumberOfSectionsListener) {
            onGetNumberOfSectionsListener = context
        }

        if (context is OnNextSectionListener) {
            onNextSectionListener = context
        }

        if (context is OnGotoSectionCorrectionListener) {
            onGotoSectionCorrectionListener = context
        }

        if (context is OnPaperScoreListener) {
            onPaperScoreListener = context
        }

        if (context is OnIsSectionAnsweredListener) {
            onIsSectionAnsweredListener = context
        }
        if(context is OnCheckPackageExpiredListener){
            onCheckPackageExpiredListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_section_result, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionIndex = sectionResultFragmentViewModel.getSectionIndex()
        val score = sectionResultFragmentViewModel.getScoreData().numberOfCorrectAnswers

        onPaperScoreListener.onUpdatePaperScore(sectionIndex, score)
        onIsSectionAnsweredListener.onUpdateIsSectionAnswered(sectionIndex)

        val tvSectionScore: TextView = view.findViewById(R.id.tvSectionScore)
        tvSectionScore.text =
            "${sectionResultFragmentViewModel.getScoreData().numberOfCorrectAnswers}/${sectionResultFragmentViewModel.getScoreData().numberOfQuestions}"

        val tvSectionPercentage: TextView = view.findViewById(R.id.tvSectionPercentage)
        tvSectionPercentage.text =
            sectionResultFragmentViewModel.getScoreData().percentage.toString()

        val rvFragment = RecyclerViewFragment.newInstance(
            requireContext().resources.getString(R.string.result),
            sectionResultFragmentViewModel.getUserMarkedAnswersSheet()
        )
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.apply {
            replace(R.id.rvFragmentHolder, rvFragment)
            commit()
        }

        val btnRetry: Button = view.findViewById(R.id.btnRetry)
//
        btnRetry.setOnClickListener {

            if(onRetrySectionListener.onGetCurrentSectionRetryCount().value == 0){
                Toast.makeText(requireContext(), requireContext().resources.getString(R.string.retry_limit_message), Toast.LENGTH_LONG).show()
                btnRetry.isEnabled = false
            }else{

                retryDialog(sectionIndex)
            }
        }

        val btnNextSection: Button = view.findViewById(R.id.btnNextSection)
        var nextSectionIndex = sectionIndex + 1

        while(nextSectionIndex < onGetNumberOfSectionsListener.onGetNumberOfSections() && onIsSectionAnsweredListener.onGetSectionsAnswered()[nextSectionIndex]){
            nextSectionIndex += 1
        }

        if (nextSectionIndex < onGetNumberOfSectionsListener.onGetNumberOfSections()){
            btnNextSection.isEnabled = true
        }

        btnNextSection.setOnClickListener {
            if(!onCheckPackageExpiredListener.onCheckPackageExpired()){
                onCheckPackageExpiredListener.onShowPackageExpiredDialog()
            }else{
//                onNextSectionListener.onResetCurrentSectionRetryCount()
                onNextSectionListener.onNextSection(nextSectionIndex)
            }

        }


        val btnCorrection: Button = view.findViewById(R.id.btnCorrection)
        btnCorrection.setOnClickListener {
            if (sectionResultFragmentViewModel.getScoreData().percentage < MINIMUM_PERCENTAGE) {
                val alertDialog = AlertDialog.Builder(requireContext())
                alertDialog.apply {
                    setMessage("Get a percentage of at least $MINIMUM_PERCENTAGE to view corrections to all wrong answers")
                    setPositiveButton("Ok") { p0, _ ->
                        p0.dismiss()
                    }
//                    setCancelable(false)
                }.create().show()
            } else {
                onGotoSectionCorrectionListener.onGotoSectionCorrection(
                    sectionIndex,
                    sectionResultFragmentViewModel.getQuestionsWithCorrectAnswer()
                )
            }
        }

        sectionResultFragmentViewModel.getHasPerfectScore().observe(viewLifecycleOwner, Observer {
            if(it){
                btnRetry.isEnabled = false
                btnCorrection.isEnabled = false
                Toast.makeText(requireContext(), requireContext().getString(R.string.excellent), Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun retryDialog(sectionIndex: Int){
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.apply {
            setMessage(requireContext().resources.getString(R.string.retry_message))
            setPositiveButton(requireContext().resources.getString(R.string._continue)) { p0, _ ->

                if(!onCheckPackageExpiredListener.onCheckPackageExpired()){
                    onCheckPackageExpiredListener.onShowPackageExpiredDialog()
                }else{

                    onRetrySectionListener.onDecrementCurrentSectionRetryCount()
                    Toast.makeText(requireContext(), "Retries left: ${onRetrySectionListener.onGetCurrentSectionRetryCount().value}", Toast.LENGTH_LONG).show()
                    onRetrySectionListener.onRetrySection(sectionIndex)
                }

                p0.dismiss()
            }
            setNegativeButton(requireContext().resources.getString(R.string.cancel)){ p0, _ ->
                p0.dismiss()
            }
            setCancelable(false)
        }.create().show()
    }

    override fun onResume() {
        super.onResume()
        requireActivity().title = "${requireContext().resources.getString(R.string.result)}"
    }


    companion object {

        fun newInstance(sectionResultData: SectionResultData, expiresOn: String): Fragment {
            val bundle = Bundle().apply {
                putSerializable(SECTION_RESULT_DATA, sectionResultData)
                putString("expiresOn", expiresOn)
            }
            val sectionResultFragment = SectionResultFragment()
            sectionResultFragment.arguments = bundle
            return sectionResultFragment
        }

    }

}