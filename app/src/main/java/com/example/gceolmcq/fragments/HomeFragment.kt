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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.R
import com.example.gceolmcq.adapters.HomeRecyclerViewAdapter
import com.example.gceolmcq.datamodels.SubjectPackageExpiryStatusData
import com.example.gceolmcq.datamodels.SubjectPackageExpiryStatusDataSerializable
import com.example.gceolmcq.viewmodels.HomeFragmentViewModel

class HomeFragment : Fragment() {

    private lateinit var homeRecyclerView: RecyclerView
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    private lateinit var onPackageActivatedListener: OnPackageActivatedListener
    private lateinit var homeRecyclerViewAdapter: HomeRecyclerViewAdapter
    private lateinit var onRequestSubjectPackageExpiryStatusDataListListener: OnRequestSubjectPackageExpiryStatusDataListListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeFragmentViewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnPackageActivatedListener) {
            onPackageActivatedListener = context
        }

        if (context is OnRequestSubjectPackageExpiryStatusDataListListener) {
            onRequestSubjectPackageExpiryStatusDataListListener = context
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

        homeRecyclerView = view.findViewById(R.id.homeRecyclerView)
    }

    override fun onResume() {
        super.onResume()

        onRequestSubjectPackageExpiryStatusDataListListener.onRequestSubjectPackageExpiryStatusLiveData()
            .observe(viewLifecycleOwner, Observer {
                homeFragmentViewModel.setSubjectPackageExpiryStatusDataList(it)

                homeRecyclerViewAdapter = HomeRecyclerViewAdapter(
                    requireContext(),
//                    it,
                    requireContext() as HomeRecyclerViewAdapter.OnHomeRecyclerItemClickListener
                )

                homeRecyclerViewAdapter.setSubjectPackageExpiryStatusList(it)
                val loMan = LinearLayoutManager(requireContext())
                loMan.orientation = LinearLayoutManager.VERTICAL
                homeRecyclerView.layoutManager = loMan
                homeRecyclerView.adapter = homeRecyclerViewAdapter

            })


        homeFragmentViewModel.packagesInitialExpiryCheck()

//        block runs only when package is activated
        onPackageActivatedListener.onPackageActivated()
            .observe(viewLifecycleOwner, Observer { subjectPackageExpiryBundle ->
                val position = subjectPackageExpiryBundle.getInt("position")
                val subjectName = subjectPackageExpiryBundle.getString("subject")!!
                val packageName = subjectPackageExpiryBundle.getString("package")!!
                val expiresOn = subjectPackageExpiryBundle.getString("expiresOn")!!
                val status = subjectPackageExpiryBundle.getBoolean("status")

                val subjectPackageExpiryStatusData = SubjectPackageExpiryStatusData(subjectName, packageName, expiresOn, status)
                homeRecyclerViewAdapter.updateSubjectPackageExpiryStatusListAt(position, subjectPackageExpiryStatusData)
//                homeFragmentViewModel.updateSubjectExpiryStatusListAt(subjectPackageExpiryBundle)
                homeRecyclerViewAdapter.notifyItemChanged(position)
                homeFragmentViewModel.checkPackageExpiry(position, expiresOn)
            })

        homeFragmentViewModel.subjectPackageExpiredIndexAndStatusBundle()
            .observe(viewLifecycleOwner, Observer { bundle ->
                val position = bundle.getInt("position")
                val status = bundle.getBoolean("status")
                homeRecyclerViewAdapter.updateExpiryStatusAt(position, status)
                homeRecyclerViewAdapter.notifyItemChanged(position)
            })
    }

    companion object {

        fun newInstance(): Fragment{
            return HomeFragment()
        }

    }

    interface OnPackageActivatedListener {
        fun onPackageActivated(): LiveData<Bundle>
    }

    interface OnRequestSubjectPackageExpiryStatusDataListListener {
        fun onRequestSubjectPackageExpiryStatusDataList(): ArrayList<SubjectPackageExpiryStatusData>
        fun onRequestSubjectPackageExpiryStatusLiveData(): LiveData<ArrayList<SubjectPackageExpiryStatusData>>
    }


}