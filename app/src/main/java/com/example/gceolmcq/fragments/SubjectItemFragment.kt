package com.example.gceolmcq.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.R
import com.example.gceolmcq.viewmodels.SubjectItemFragmentViewModel


const val SUBJECT_NAME = "subject name"
const val POSITION = "position"

class SubjectItemFragment : Fragment() {
    private lateinit var subjectItemFragmentViewModel: SubjectItemFragmentViewModel
    private lateinit var onSubjectItemClickedListener: OnSubjectItemClickedListener
    private lateinit var onSubjectPackageExpiresOnListener: OnSubjectPackageExpiresOnListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subjectItemFragmentViewModel =
            ViewModelProvider(this)[SubjectItemFragmentViewModel::class.java]
        subjectItemFragmentViewModel.setSubjectName(requireArguments().getString(SUBJECT_NAME)!!)
        subjectItemFragmentViewModel.updateSubjectPosition(requireArguments().getInt(POSITION))

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSubjectItemClickedListener) {
            onSubjectItemClickedListener = context
        }

        if (context is OnSubjectPackageExpiresOnListener) {
            onSubjectPackageExpiresOnListener = context
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.subject_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvSubjectName = view.findViewById(R.id.tvSubjectNavItem) as TextView
        val tvSubjectStatus = view.findViewById(R.id.tvSubjectStatus) as TextView
        val btnSubjectPackageDetails = view.findViewById(R.id.btnPackage) as Button
        val btnSubscribe = view.findViewById(R.id.btnSubscribe) as Button
        val layoutSubjectItem = view.findViewById(R.id.layoutSubjectNavItem) as LinearLayout

        tvSubjectName.text = subjectItemFragmentViewModel.getSubjectName()

        subjectItemFragmentViewModel.getIsSubjectPackageActive()
            .observe(viewLifecycleOwner, Observer { isPackageActive ->
                if (isPackageActive) {
                    btnSubscribe.isEnabled = false
                    btnSubjectPackageDetails.isEnabled = true
                    tvSubjectStatus.text = requireContext().resources.getString(R.string.active)
                    tvSubjectStatus.setTextColor(requireContext().resources.getColor(R.color.blue_color))
                    btnSubjectPackageDetails.setOnClickListener {
                        onSubjectItemClickedListener.onPackageDetailsButtonClicked(
                            subjectItemFragmentViewModel.getSubjectPosition(),
                            isPackageActive
                        )
                    }

                } else {
                    btnSubscribe.isEnabled = true
                    btnSubjectPackageDetails.isEnabled = false
                    tvSubjectStatus.text = requireContext().resources.getString(R.string.expired)
                    tvSubjectStatus.setTextColor(requireContext().resources.getColor(R.color.red_color))

                    btnSubscribe.setOnClickListener {
                        onSubjectItemClickedListener.onSubscribeButtonClicked(
                            subjectItemFragmentViewModel.getSubjectPosition()
                        )
                    }

                }
//                println("Subject item fragment")
                onSubjectPackageExpiresOnListener.onSubjectPackageExpiresOn().observe(viewLifecycleOwner, Observer{
//                    println("Expires on: ${ it[subjectItemFragmentViewModel.getSubjectPosition()] }")
                    subjectItemFragmentViewModel.updateExpiresOn(it!![subjectItemFragmentViewModel.getSubjectPosition()])
                    subjectItemFragmentViewModel.checkSubjectPackageExpiry()
                })

//                subjectItemFragmentViewModel.updateExpiresOn(onSubjectPackageExpiresOnListener.onSubjectPackageExpiresOn()[subjectItemFragmentViewModel.getSubjectPosition()])
//                subjectItemFragmentViewModel.checkSubjectPackageExpiry()

                layoutSubjectItem.setOnClickListener {
                    onSubjectItemClickedListener.onSubjectItemClicked(
                        subjectItemFragmentViewModel.getSubjectPosition(),
                        isPackageActive
                    )
                }
            })



    }


    companion object {
        fun newInstance(subjectName: String, position: Int): Fragment {
            val subjectItemFragment = SubjectItemFragment()
            subjectItemFragment.arguments =
                Bundle().apply {
                    putString(SUBJECT_NAME, subjectName)
                    putInt(POSITION, position)
                }
            return subjectItemFragment
        }
    }

    interface OnSubjectItemClickedListener {
        fun onSubjectItemClicked(position: Int, isPackageActive: Boolean)
        fun onSubscribeButtonClicked(position: Int)
        fun onPackageDetailsButtonClicked(position: Int, isPackageActive: Boolean)
    }

    interface OnSubjectPackageExpiresOnListener {
        fun onSubjectPackageExpiresOn(): LiveData<ArrayList<String>?>
    }
}