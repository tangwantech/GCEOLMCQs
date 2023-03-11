package com.example.gceolmcq.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.gceolmcq.*
import com.example.gceolmcq.activities.*
import com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData

private const val CORRECTION_DATA = "Correction data"
private const val SECTION_INDEX = "index"

class CorrectionFragment : Fragment() {
    private lateinit var onNextSectionListener: OnNextSectionListener
    private lateinit var onRetrySectionListener: OnRetrySectionListener
    private lateinit var onGetNumberOfSectionsListener: OnGetNumberOfSectionsListener
    private lateinit var onCheckPackageExpiredListener: OnCheckPackageExpiredListener
    private lateinit var onIsSectionAnsweredListener: OnIsSectionAnsweredListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().title = context.resources.getString(R.string.correction)
        if (context is OnNextSectionListener) {
            onNextSectionListener = context
        }

        if (context is OnRetrySectionListener) {
            onRetrySectionListener = context
        }

        if(context is OnGetNumberOfSectionsListener){
            onGetNumberOfSectionsListener = context
        }

        if(context is OnCheckPackageExpiredListener){
            onCheckPackageExpiredListener = context
        }

        if (context is OnIsSectionAnsweredListener) {
            onIsSectionAnsweredListener = context
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_correction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionIndex = requireArguments().getInt(SECTION_INDEX)

        val rvCorrectionFragment = RecyclerViewFragment.newInstance(
            requireActivity().title.toString(),
            requireArguments().getSerializable(CORRECTION_DATA) as UserMarkedAnswersSheetData
        )

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.apply {
            replace(R.id.holderRvFragmentCorrection, rvCorrectionFragment)
            commit()
        }

//        val btnRetry: Button = view.findViewById(R.id.btnRetryCorrection)
//        btnRetry.setOnClickListener {
//            onRetrySectionListener.onRetrySection(sectionIndex)
//        }

        val btnNextSection: Button = view.findViewById(R.id.btnNextSection)
        var nextSectionIndex = sectionIndex + 1

        while(nextSectionIndex < onGetNumberOfSectionsListener.onGetNumberOfSections() && onIsSectionAnsweredListener.onGetSectionsAnswered()[nextSectionIndex]){
            nextSectionIndex += 1
        }

        if(nextSectionIndex < onGetNumberOfSectionsListener.onGetNumberOfSections()){
            btnNextSection.isEnabled = true
        }
        btnNextSection.setOnClickListener {
            if(!onCheckPackageExpiredListener.onCheckPackageExpired()){
                onCheckPackageExpiredListener.onShowPackageExpiredDialog()
            }else{
                onNextSectionListener.onNextSection(nextSectionIndex)
            }

        }

    }

    companion object {

        fun newInstance(sectionIndex: Int, userMarkedAnswersSheetData: UserMarkedAnswersSheetData, expiresOn: String): Fragment {
            val bundle = Bundle()
            bundle.putString("expiresOn", expiresOn)
            bundle.putSerializable(CORRECTION_DATA, userMarkedAnswersSheetData)
            bundle.putInt(SECTION_INDEX, sectionIndex)
            val correctionFragment = CorrectionFragment()
            correctionFragment.arguments = bundle
            return correctionFragment
        }

    }
}