package com.example.gceolmcq.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.activities.OnIsSectionAnsweredListener
import com.example.gceolmcq.activities.OnPaperScoreListener
import com.example.gceolmcq.R
//import com.example.gceolmcq.activities.OnPackageExpiredListener
import com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter
//import com.example.gceolmcq.datamodels.SectionAnsweredScoreData
import com.example.gceolmcq.viewmodels.SectionNavigationFragmentViewModel

private const val SECTION_NAMES = "Section names"
private const val NUMBER_OF_QUESTIONS = "Number of questions"
private const val MINIMUM_PASS_PERCENTAGE = 50

class SectionNavigationFragment : Fragment(){
    private lateinit var onRecyclerItemClickListener: SectionNavigationRecyclerViewAdapter.OnRecyclerItemClickListener

    private lateinit var onRequestNavigationDataListener: OnRequestNavigationDataListener

    private lateinit var onPaperScoreListener: OnPaperScoreListener
    private lateinit var onIsSectionAnsweredListener: OnIsSectionAnsweredListener

    private lateinit var sectionNavigationFragmentViewModel: SectionNavigationFragmentViewModel
//    private lateinit var onCheckPackageExpiredListener: OnCheckPackageExpiredListener

    private lateinit var tvSectionsAnswered: TextView
    private lateinit var tvScore: TextView
    private lateinit var tvPaperGrade: TextView
    private lateinit var paperGradeLayout: LinearLayout
    private lateinit var rvSectionNav: RecyclerView

    private var fadeInOut: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fadeInOut = AnimationUtils.loadAnimation(requireContext(), R.anim.cross_fade)
        fadeInOut?.repeatMode = Animation.REVERSE

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_section_navigation, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        initHelperListeners(context)


    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        initViews(view)
        setupAdapters()
        setupViewObservers()

    }

    private fun initHelperListeners(context: Context){
        if (context is SectionNavigationRecyclerViewAdapter.OnRecyclerItemClickListener) {
            onRecyclerItemClickListener = context
        }

        if (context is OnRequestNavigationDataListener) {
            onRequestNavigationDataListener = context
        }

        if (context is OnPaperScoreListener){
            onPaperScoreListener = context
        }

        if (context is OnIsSectionAnsweredListener){
            onIsSectionAnsweredListener = context
        }

//        if (context is OnCheckPackageExpiredListener){
//            onCheckPackageExpiredListener = context
//        }
    }

    private fun initViews(view: View){
        tvPaperGrade = view.findViewById(R.id.tvPaperGrade)
        paperGradeLayout = view.findViewById(R.id.paperGradeLayout)
        rvSectionNav = view.findViewById(R.id.rvSectionNavigation)
        tvSectionsAnswered = view.findViewById(R.id.tvSectionsAnswered)
        tvScore = view.findViewById(R.id.tvScore)
    }

    private fun setupViewModel(){
        sectionNavigationFragmentViewModel =
            ViewModelProvider(this)[SectionNavigationFragmentViewModel::class.java]

        sectionNavigationFragmentViewModel.setSectionNames(onRequestNavigationDataListener.onRequestSectionNames())
        sectionNavigationFragmentViewModel.setSectionNameBundleList(onRequestNavigationDataListener.onRequestSectionNameBundleList())
        sectionNavigationFragmentViewModel.setTotalNumberOfQuestions(onRequestNavigationDataListener.onRequestTotalNumberOfQuestions())
        sectionNavigationFragmentViewModel.updateSectionsAnswered(onIsSectionAnsweredListener.onGetSectionsAnswered())
        sectionNavigationFragmentViewModel.updatePaperScore(onPaperScoreListener.onGetPaperScore())
    }

    private fun setupAdapters(){
        val sectionNames = sectionNavigationFragmentViewModel.getSectionNames()
        val sectionNameBundleList = sectionNavigationFragmentViewModel.getSectionNameBundleList()
        val rvLayoutMan = LinearLayoutManager(requireContext())
        rvLayoutMan.orientation = LinearLayoutManager.VERTICAL
        rvSectionNav.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        rvSectionNav.layoutManager = rvLayoutMan

        val sectionNavigationRecyclerViewAdapter =
            SectionNavigationRecyclerViewAdapter(
                requireContext(),
//                sectionNames!!,
                sectionNameBundleList!!,
                onRecyclerItemClickListener,
                sectionNavigationFragmentViewModel.getSectionsAnswered()
            )

        rvSectionNav.adapter = sectionNavigationRecyclerViewAdapter
    }

    private fun setupViewObservers(){
        sectionNavigationFragmentViewModel.getNumberOfSectionsAnswered().observe(viewLifecycleOwner, Observer {
            tvSectionsAnswered.text =
                "$it/${sectionNavigationFragmentViewModel.getNumberOfSections()}"
        })

        sectionNavigationFragmentViewModel.getPaperScore().observe(viewLifecycleOwner, Observer {
            tvScore.text = "$it/${sectionNavigationFragmentViewModel.getTotalNumberOfQuestions()}"

        })

        sectionNavigationFragmentViewModel.getPaperGrade().observe(viewLifecycleOwner, Observer {
            tvPaperGrade.text = it
        })

        sectionNavigationFragmentViewModel.getAreAllSectionsAnswered().observe(viewLifecycleOwner, Observer {
            if(it){
                paperGradeLayout.visibility = View.VISIBLE
                tvPaperGrade.startAnimation(fadeInOut)
            }
        })

        sectionNavigationFragmentViewModel.getPaperPercentage().observe(viewLifecycleOwner, Observer {
            if(it >= MINIMUM_PASS_PERCENTAGE){
                tvPaperGrade.setTextColor(requireContext().resources.getColor(R.color.blue_color))
            }else{
                tvPaperGrade.setTextColor(requireContext().resources.getColor(R.color.red_color))
            }
        })
    }

    override fun onResume() {
        super.onResume()
        sectionNavigationFragmentViewModel.updateSectionsAnswered(onIsSectionAnsweredListener.onGetSectionsAnswered())
        sectionNavigationFragmentViewModel.updatePaperScore(onPaperScoreListener.onGetPaperScore())
    }

    companion object {

        fun newInstance(): Fragment {
            return SectionNavigationFragment()
        }

    }

    interface OnRequestNavigationDataListener {
        fun onRequestSectionNames(): Array<String>?
        fun onRequestSectionNameBundleList(): Array<Bundle>?
        fun onRequestTotalNumberOfQuestions(): Int
    }

//    interface OnPackageExpiredListener{
//        fun onPackageExpired()
//    }

}

