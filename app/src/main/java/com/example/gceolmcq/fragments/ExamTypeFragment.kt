package com.example.gceolmcq.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.activities.PaperActivity
import com.example.gceolmcq.R
//import com.example.gceolmcq.activities.OnPackageExpiredListener
import com.example.gceolmcq.adapters.ExamTypeRecyclerViewAdapter
import com.example.gceolmcq.datamodels.ExamTypeDataModel
import com.example.gceolmcq.viewmodels.ExamTypeFragmentViewModel


class ExamTypeFragment : Fragment(), ExamTypeRecyclerViewAdapter.OnRecyclerItemClickListener {
//    private lateinit var examContents: ExamTypeDataModel
    private lateinit var examTypeFragmentViewModel: ExamTypeFragmentViewModel
    private lateinit var onPackageExpiredListener: OnPackageExpiredListener
    private lateinit var onContentAccessListener: OnContentAccessListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exam_type, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvExamTypeFragment: RecyclerView = view.findViewById(R.id.rvExamTypeFragment)

        val rvLayoutMan = LinearLayoutManager(requireActivity())
        rvLayoutMan.orientation = LinearLayoutManager.VERTICAL
        rvExamTypeFragment.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        rvExamTypeFragment.layoutManager = rvLayoutMan
        val rvAdapter = ExamTypeRecyclerViewAdapter(
            requireContext(),
            examTypeFragmentViewModel.getExamTypeItemsData(),
            this
        )
        rvExamTypeFragment.adapter = rvAdapter
        rvExamTypeFragment.setHasFixedSize(true)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        examTypeFragmentViewModel = ViewModelProvider(this)[ExamTypeFragmentViewModel::class.java]
        val examTypeDataModel = requireArguments().getSerializable("examTypeData") as ExamTypeDataModel
        examTypeFragmentViewModel.setExamTypeData(examTypeDataModel)

        if(context is OnPackageExpiredListener){
            onPackageExpiredListener = context
        }

        if(context is OnContentAccessListener){
            onContentAccessListener = context
        }

    }


    companion object {
        fun newInstance(examTypeDataModel: ExamTypeDataModel, subjectName: String, expiresOn: String, packageName: String): Fragment {
            val examFragment = ExamTypeFragment()
            val bundle = Bundle()
            bundle.putString("expiresOn", expiresOn)
            bundle.putSerializable("examTypeData", examTypeDataModel)
            bundle.putString("subjectName", subjectName)
            bundle.putString("packageName", packageName)
            examFragment.arguments = bundle
            return examFragment
        }
    }

    override fun onRecyclerItemClick(position: Int) {

        if(requireArguments().getString("packageName")!! == requireContext().getString(R.string.trial)){
            if(position == 0){
                gotoPaperActivity(position)
            }else{
                onContentAccessListener.onContentAccessDenied()
            }
        }else{
            if(!ActivationExpiryDatesGenerator().checkExpiry(requireArguments().getString("expiresOn")!!)){
                onPackageExpiredListener.onPackageExpired()
            }else{
                gotoPaperActivity(position)
            }
        }
//        if(!ActivationExpiryDatesGenerator().checkExpiry(requireArguments().getString("expiresOn")!!)){
//            onPackageExpiredListener.onPackageExpired()
//        }else{
//            gotoPaperActivity(position)
//        }


    }
    private fun gotoPaperActivity(position: Int){
        val intent = Intent(requireContext(), PaperActivity::class.java)
        val bundle = Bundle()
        bundle.putString("expiresOn", requireArguments().getString("expiresOn"))
        bundle.putString("subjectName", requireArguments().getString("subjectName"))
        bundle.putSerializable("paperSerializable", examTypeFragmentViewModel.getExamItemDataAt(position))
//        bundle.putString("subjectName", )
        intent.putExtra("paperData", bundle)
        startActivity(intent)
    }


    interface OnPackageExpiredListener{
        fun onPackageExpired()
    }
    interface OnContentAccessListener{
        fun onContentAccessDenied()
    }


}