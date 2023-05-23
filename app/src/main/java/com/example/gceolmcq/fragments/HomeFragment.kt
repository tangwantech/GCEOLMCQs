package com.example.gceolmcq.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.HomeRecyclerViewAdapter
import com.example.gceolmcq.viewmodels.HomeFragmentViewModel

class HomeFragment : Fragment(), HomeRecyclerViewAdapter.OnCheckPackageExpiryListener {

    private lateinit var homeRecyclerView: RecyclerView
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    private lateinit var onPackageActivatedListener: OnPackageActivatedListener
    private lateinit var homeRecyclerViewAdapter: HomeRecyclerViewAdapter
    private lateinit var onHomeRecyclerItemClickListener: HomeRecyclerViewAdapter.OnHomeRecyclerItemClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnPackageActivatedListener) {
            onPackageActivatedListener = context
        }

        if (context is HomeRecyclerViewAdapter.OnHomeRecyclerItemClickListener){
            onHomeRecyclerItemClickListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initHomeFragmentViews(view)
        setupHomeFragmentRecyclerView()
        setupHomeFragmentViewObservers()
    }

    private fun initViewModel(){
        homeFragmentViewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]
        homeFragmentViewModel.initGceOLMcqDatabase(requireContext())

    }

    private fun initHomeFragmentViews(view: View){
        homeRecyclerView = view.findViewById(R.id.homeRecyclerView)
    }

    private fun setupHomeFragmentAdapter(){
        homeRecyclerViewAdapter = HomeRecyclerViewAdapter(
            requireContext(),
            homeFragmentViewModel.subjectPackageDataList.value!!,
            onHomeRecyclerItemClickListener,
            this
        )

    }

    private fun setupHomeFragmentRecyclerView() {
        setupHomeFragmentAdapter()
        val loMan = LinearLayoutManager(requireContext())
        loMan.orientation = LinearLayoutManager.VERTICAL
        homeRecyclerView.layoutManager = loMan
//        homeRecyclerView.addItemDecoration(
//            DividerItemDecoration(
//                requireContext(),
//                DividerItemDecoration.VERTICAL
//            )
//        )
        homeRecyclerView.adapter = homeRecyclerViewAdapter

    }

    private fun setupHomeFragmentViewObservers(){

        onPackageActivatedListener.onPackageActivated().observe(viewLifecycleOwner, Observer {
            homeFragmentViewModel.initSubjectPackagesDataListFromLocalDatabase()
        })

        homeFragmentViewModel.subjectPackageDataList.observe(viewLifecycleOwner, Observer {
            if(it!!.isNotEmpty()){
                homeRecyclerViewAdapter.upSubjectPackageData(it)
                homeRecyclerView.adapter!!.notifyDataSetChanged()

            }
        })

        homeFragmentViewModel.packageExpiredIndex.observe(viewLifecycleOwner, Observer {
            homeFragmentViewModel.initSubjectPackagesDataListFromLocalDatabase()
        })
    }

    override fun onResume() {
        super.onResume()
        homeFragmentViewModel.initSubjectPackagesDataListFromLocalDatabase()

    }

    companion object {

        fun newInstance(): Fragment{
            return HomeFragment()
        }

    }

    interface OnPackageActivatedListener {
        fun onPackageActivated(): LiveData<Int>
    }

    override fun onCheckPackageExpiry(position: Int) {
        homeFragmentViewModel.checkPackageExpiry(position)
    }


}