package com.example.gceolmcq.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.ExamTypeRecyclerViewAdapter
import com.example.gceolmcq.datamodels.ExamTypeDataModel
import com.example.gceolmcq.viewmodels.SubjectStatisticsTabContentFragmentViewModel

//private const val SUBJECT_AND_FILE_NAME = "subjectAndFileNameData"
class SubjectStatisticsTabContentFragment : Fragment(),
    ExamTypeRecyclerViewAdapter.OnRecyclerItemClickListener {
    private lateinit var subjectStatisticsTabContentFragmentViewModel: SubjectStatisticsTabContentFragmentViewModel
    private lateinit var clickListener: SubjectStatisticsTabContentFragment.OnRecyclerItemClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subject_statistics_tab_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subjectStatisticsTabContentFragmentViewModel =
            ViewModelProvider(this)[SubjectStatisticsTabContentFragmentViewModel::class.java]
        val examTypeDataModel =
            requireArguments().getSerializable("examTypeData") as ExamTypeDataModel
        subjectStatisticsTabContentFragmentViewModel.setExamTypeData(examTypeDataModel)

        val rv: RecyclerView = view.findViewById(R.id.rvSubjectStatisticsContentFragment)

        val rvLayoutMan = LinearLayoutManager(requireActivity())
        rvLayoutMan.orientation = LinearLayoutManager.VERTICAL
        rv.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        rv.layoutManager = rvLayoutMan
        val rvAdapter = ExamTypeRecyclerViewAdapter(
            requireContext(),
            subjectStatisticsTabContentFragmentViewModel.getExamTypeItemsData(),
            this
        )
        rv.adapter = rvAdapter
        rv.setHasFixedSize(true)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SubjectStatisticsTabContentFragment.OnRecyclerItemClickListener) {
            clickListener = context
        }
    }


    companion object {

        fun newInstance(examTypeData: ExamTypeDataModel): Fragment {

            val subjectStatisticsTabContentFragment = SubjectStatisticsTabContentFragment()
            val bundle = Bundle()
            bundle.putSerializable("examTypeData", examTypeData)
            subjectStatisticsTabContentFragment.arguments = bundle
            return subjectStatisticsTabContentFragment
        }
    }

    override fun onRecyclerItemClick(position: Int) {
        println("position clicked: $position")

        clickListener.onRecyclerItemClicked(
            subjectStatisticsTabContentFragmentViewModel.getExamItemTextValueAt(
                position
            )
        )
    }

    interface OnRecyclerItemClickListener {
        fun onRecyclerItemClicked(value: String)
    }
}



