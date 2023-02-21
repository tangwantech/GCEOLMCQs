package com.example.gceolmcq.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.R
import com.example.gceolmcq.datamodels.SubscriptionFormDataModel
import com.example.gceolmcq.viewmodels.SubscriptionFormDialogFragmentViewModel
import com.google.android.material.textfield.TextInputEditText

private const val SUBJECT_POSITION = "subject_position"
private const val SUBJECT_TITLE = "subject_title"

class SubscriptionFormDialogFragment : DialogFragment() {
    private lateinit var subscriptionFormDialogFragmentViewModel: SubscriptionFormDialogFragmentViewModel
    private lateinit var onActivateButtonClickListener: OnActivateButtonClickListener

    private lateinit var dialogTitle: TextView
    private lateinit var autoPackageType: AutoCompleteTextView
    private lateinit var layoutTvPrice: LinearLayout
    private lateinit var tvPrice: TextView
    private lateinit var autoMomoPartner: AutoCompleteTextView
    private lateinit var etMomoNumber: TextInputEditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnActivateButtonClickListener) {
            onActivateButtonClickListener = context
        }

        setUpViewModel()

        subscriptionFormDialogFragmentViewModel.setSubjectPosition(
            requireArguments().getInt(
                SUBJECT_POSITION
            )
        )

        subscriptionFormDialogFragmentViewModel.updateDialogTitle(requireArguments().getString(
            SUBJECT_TITLE)!!)

    }

    private fun setUpViewModel(){
        subscriptionFormDialogFragmentViewModel =
            ViewModelProvider(this)[SubscriptionFormDialogFragmentViewModel::class.java]
    }

    private fun initViews(): View{
        val view =
            requireActivity().layoutInflater.inflate(R.layout.fragment_subcription_form, null)
        dialogTitle = view.findViewById(R.id.tvSubscriptionFormTitle)
        layoutTvPrice = view.findViewById(R.id.layoutPackagePrice)
        tvPrice = view.findViewById(R.id.tvPackagePrice)
        autoMomoPartner = view.findViewById(R.id.autoCompleteMomoPartner)
        etMomoNumber = view.findViewById(R.id.etMomoNumber)
        autoPackageType = view.findViewById(R.id.autoCompletePackageType)
        return view
    }

    private fun setUpViews(){
        dialogTitle.text = subscriptionFormDialogFragmentViewModel.getDialogTitle()
        autoPackageType.setAdapter(
            ArrayAdapter<String>(
                requireContext(),
                R.layout.drop_down_item,
                subscriptionFormDialogFragmentViewModel.getPackageTypes()
            )
        )

        autoMomoPartner.setAdapter(
            ArrayAdapter<String>(
                requireContext(),
                R.layout.drop_down_item,
                subscriptionFormDialogFragmentViewModel.getMoMoPartners()
            )
        )
    }

    private fun setUpViewListeners(){
        autoPackageType.setOnItemClickListener { _, _, i, _ ->
            subscriptionFormDialogFragmentViewModel.setPackageType(i)
        }

        autoMomoPartner.setOnItemClickListener { _, _, i, _ ->
            subscriptionFormDialogFragmentViewModel.setMomoPartner(i)
        }

        etMomoNumber.doOnTextChanged { text, _, _, _ ->
            subscriptionFormDialogFragmentViewModel.setMomoNumber(text.toString())

        }
    }

    private fun setUpViewObservers(dialogPositiveBtn: Button){
        subscriptionFormDialogFragmentViewModel.getIsPackageSelected().observe(this, Observer {
            if(it){
                layoutTvPrice.visibility = View.VISIBLE
                tvPrice.text = "${subscriptionFormDialogFragmentViewModel.getPackagePrice()} FCFA"

            }
        })

        subscriptionFormDialogFragmentViewModel.isSubscriptionFormFilled.observe(this, Observer {
            dialogPositiveBtn.isEnabled = it
        })
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view = initViews()
        setUpViews()
        setUpViewListeners()
        return setUpAlertDialog(view)
    }
    private fun setUpAlertDialog(view: View): Dialog{
        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setView(view)
            setPositiveButton("Activate"){ _, _ ->
                onActivateButtonClickListener.onActivateButtonClicked(
                    subscriptionFormDialogFragmentViewModel.getSubscriptionFormData())
            }
            setNegativeButton("Cancel") { btn, _ ->
                btn.dismiss()
            }
        }

        val dialog = builder.create()
        dialog.setOnShowListener {
            val positiveBtn = (dialog as AlertDialog).getButton(AlertDialog.BUTTON_POSITIVE)
            positiveBtn.isEnabled = false

            setUpViewObservers(positiveBtn)

        }
        return dialog
    }

    companion object {
        fun newInstance(position: Int, subjectName: String): DialogFragment {
            val subscriptionFormDialogFragment = SubscriptionFormDialogFragment()
            val bundle = Bundle().apply {
                putInt(SUBJECT_POSITION, position)
                putString(SUBJECT_TITLE, subjectName)
            }
            subscriptionFormDialogFragment.arguments = bundle
            return subscriptionFormDialogFragment
        }
    }


    interface OnActivateButtonClickListener {
        fun onActivateButtonClicked(subscriptionFormDataModel: SubscriptionFormDataModel)
    }
}