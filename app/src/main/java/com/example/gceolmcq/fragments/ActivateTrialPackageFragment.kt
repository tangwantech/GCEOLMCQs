package com.example.gceolmcq.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.R
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.example.gceolmcq.viewmodels.ActivateTrialPackageFragmentViewModel

class ActivateTrialPackageFragment : Fragment() {

    private lateinit var viewModel: ActivateTrialPackageFragmentViewModel
    private var subjects: ArrayList<String>? = null
    private lateinit var onSubjectsPackagesAvailableListener: OnSubjectsPackagesAvailableListener

    private lateinit var subjectsAvailableTv: TextView
    private lateinit var packageDurationTV: TextView
    private lateinit var activateBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnSubjectsPackagesAvailableListener){
            onSubjectsPackagesAvailableListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activate_trial_package, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setDatabase()
        setSubjects()
        setMobileId()
        initViews(view)
        setupViewsListeners()
        setViewObservers()

    }

    private fun setMobileId(){
        arguments?.let {
            val id = it.getString(MCQConstants.MOBILE_ID)!!
            viewModel.setMobileId(id)
        }
    }

    private fun setSubjects(){
        arguments?.let {
            val subjects = it.getStringArrayList(MCQConstants.SUBJECTS)!!
//            println(subjects)
            viewModel.setSubjectNames(subjects)
        }

    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[ActivateTrialPackageFragmentViewModel::class.java]
    }

    private fun setDatabase(){
        viewModel.setSubjectDataBase(GceOLMcqDatabase.getDatabase(requireContext()))
    }

    private fun initViews(view: View){
        subjectsAvailableTv = view.findViewById(R.id.subjectsAvailableTv)
        packageDurationTV = view.findViewById(R.id.trialPackageDurationTv)
        packageDurationTV.text = "${MCQConstants.TRIAL_DURATION} Hours"
        activateBtn = view.findViewById(R.id.activateButton)
    }

    private fun setupViewsListeners(){
        activateBtn.setOnClickListener {
            println("Activate button clicked")
            viewModel.readSubjectsPackagesByMobileIdFromRemoteRepo()
        }
    }

    private fun setViewObservers(){
        viewModel.areSubjectsPackageDataAvailable.observe(viewLifecycleOwner){
            it?.let {
                onSubjectsPackagesAvailableListener.onSubjectsPackagesAvailable(it)
            }
        }

        viewModel.subjectsAvailable.observe(viewLifecycleOwner){
            val subjects = it.joinToString(",")
            subjectsAvailableTv.text = subjects
        }

        viewModel.remoteRepoErrorMessage.observe(viewLifecycleOwner){
            println(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(subjects: ArrayList<String>, mobileId: String) =
            ActivateTrialPackageFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(MCQConstants.SUBJECTS, subjects)
                    putString(MCQConstants.MOBILE_ID, mobileId)
                }
            }
    }

    interface OnSubjectsPackagesAvailableListener{
        fun onSubjectsPackagesAvailable(isAvailable: Boolean)
    }
}