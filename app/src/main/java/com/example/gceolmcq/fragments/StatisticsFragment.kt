package com.example.gceolmcq.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.SubjectListFragmentRecyclerAdapter
import com.example.gceolmcq.viewmodels.StatisticsFragmentViewModel

private const val INIT_DATA_BUNDLE = "initDataBundle"

class StatisticsFragment : Fragment() {
    private lateinit var recyclerItemClickListener: SubjectListFragmentRecyclerAdapter.OnRecyclerViewItemClick
    private lateinit var statisticsFragmentViewModel: StatisticsFragmentViewModel

    private lateinit var rv: RecyclerView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is SubjectListFragmentRecyclerAdapter.OnRecyclerViewItemClick){
            recyclerItemClickListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initViewModel()
        setupRecyclerView()


    }

    private fun initViews(view: View){
        rv = view.findViewById(R.id.rvStatisticsSubjectList)
    }

    private fun initViewModel(){
        statisticsFragmentViewModel = ViewModelProvider(this)[StatisticsFragmentViewModel::class.java]
        arguments?.let {
            val bundle = it.getBundle(INIT_DATA_BUNDLE)
            bundle.apply {
                this?.let { bundle ->
                    statisticsFragmentViewModel.setInitDataBundle(bundle)
                }

            }


        }
    }

    private fun setupRecyclerView(){
        val layoutMan = LinearLayoutManager(requireContext())
        layoutMan.orientation = LinearLayoutManager.VERTICAL

        rv.layoutManager = layoutMan
        rv.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        val adapter = SubjectListFragmentRecyclerAdapter(
            requireContext(),
            statisticsFragmentViewModel.getSubjectNames(),
            recyclerItemClickListener
        )
        rv.adapter = adapter
    }

    companion object {

        fun newInstance(bundle: Bundle?) =
            StatisticsFragment().apply {
                arguments = Bundle().apply {
                    putBundle(INIT_DATA_BUNDLE, bundle)
                }
            }
    }
}