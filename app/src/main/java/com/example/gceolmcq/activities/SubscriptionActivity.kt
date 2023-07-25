package com.example.gceolmcq.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.MomoPayService
import com.example.gceolmcq.R
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.datamodels.SubscriptionFormData
import com.example.gceolmcq.fragments.SubscriptionFormDialogFragment
import com.example.gceolmcq.viewmodels.SubscriptionActivityViewModel

abstract class SubscriptionActivity: AppCompatActivity(), SubscriptionFormDialogFragment.OnPayButtonClickListener{

    private lateinit var processingAlertDialog: AlertDialog
    private lateinit var requestToPayDialog: AlertDialog
    private lateinit var activatingPackageDialog: AlertDialog

    private lateinit var viewModel: SubscriptionActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initProcessingDialog()
        initRequestToPayDialog()
        initActivatingPackageDialog()
        setupViewModel()
        setupViewObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[SubscriptionActivityViewModel::class.java]
        viewModel.setRepositoryLink(this, getMobileID())

        viewModel.initSubjectDataBase(this)

        viewModel.setMobileId(getMobileID())
        viewModel.setMomoPayService(MomoPayService(this))
    }

    private fun initRequestToPayDialog() {
        requestToPayDialog = AlertDialog.Builder(this).create()
        requestToPayDialog.apply {
            setCancelable(false)
        }
    }

    private fun initActivatingPackageDialog() {
        activatingPackageDialog = AlertDialog.Builder(this).create()
        activatingPackageDialog.apply {
            setCancelable(false)
        }
    }

    private fun initProcessingDialog() {
        processingAlertDialog = AlertDialog.Builder(this).create()
        processingAlertDialog.apply {
            setCancelable(false)
        }
    }

    private fun setupViewObservers() {
        viewModel.getAreSubjectsPackagesAvailable().observe(this){
            if(activatingPackageDialog.isShowing){
                cancelActivatingPackageDialog()
            }
            showPackageActivatedDialog()
        }

        viewModel.getRemoteRepoErrorEncountered().observe(this){
            println("Error encountered: $it")
        }

        viewModel.getTransactionStatus().observe(this) {
            if (it.status == MCQConstants.PENDING) {
                cancelProcessingRequestDialog()
                if (!requestToPayDialog.isShowing) {
                    requestUserToPayDialog()
                }
            }
        }

        viewModel.isTransactionSuccessful().observe(this) {
            if (processingAlertDialog.isShowing) {
                cancelProcessingRequestDialog()
            }
            cancelRequestToPayDialog()
            if (it) {
                Toast.makeText(
                    this,
                    resources.getString(R.string.payment_received),
                    Toast.LENGTH_LONG
                ).show()
                showActivatingPackageDialog()
                activateUserPackage()
            } else {
                showTransactionFailedDialog(viewModel.subscriptionData.value?.packageType!!)
                resetMomoPayService()
            }
        }

    }

    open fun showPackageExpiredDialog(){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setMessage(resources.getString(R.string.package_expired_message))
            setPositiveButton("Ok") { _, _ ->

            }
        }.create().show()
    }

    private fun showProcessingRequestDialog() {
        processingAlertDialog.setMessage(resources.getString(R.string.processing_request))
        processingAlertDialog.show()
    }

    private fun cancelProcessingRequestDialog() {
        processingAlertDialog.cancel()
    }

    private fun showActivatingPackageDialog() {
        activatingPackageDialog.setMessage(resources.getString(R.string.activating_package_message))
        activatingPackageDialog.show()
    }

    private fun cancelActivatingPackageDialog() {
        activatingPackageDialog.cancel()
    }

    private fun showSubscriptionForm(position: Int, subjectName: String) {
        val subscriptionFormDialogFragment = SubscriptionFormDialogFragment.newInstance(
            position,
            subjectName
        )
        subscriptionFormDialogFragment.isCancelable = false
        subscriptionFormDialogFragment.show(supportFragmentManager, "subscription_form_dialog")
    }

    private fun requestUserToPayDialog() {
        val dialogView = layoutInflater.inflate(R.layout.fragment_request_to_pay, null)
        val tvRequestToPayMessage: TextView = dialogView.findViewById(R.id.tvRequestToPayMessage)
        val tvRequestToPaySubject: TextView =
            dialogView.findViewById(R.id.tvRequestToPaySubject)
        val tvRequestToPayPackageType: TextView =
            dialogView.findViewById(R.id.tvRequestToPayPackage)
        val tvRequestToPayPackagePrice: TextView =
            dialogView.findViewById(R.id.tvRequestToPayAmount)

        if (viewModel.subscriptionData.value?.momoPartner == "MTN") {
            tvRequestToPayMessage.text = resources.getString(R.string.mtn_request_to_pay_message)
        } else {
            tvRequestToPayMessage.text = resources.getString(R.string.orange_request_to_pay_message)
        }

        tvRequestToPaySubject.text = viewModel.subscriptionData.value?.subject
        tvRequestToPayPackageType.text = viewModel.subscriptionData.value?.packageType
        tvRequestToPayPackagePrice.text = "${viewModel.subscriptionData.value?.packagePrice} FCFA"


        requestToPayDialog.setView(dialogView)
        requestToPayDialog.show()

    }

    private fun cancelRequestToPayDialog() {
        requestToPayDialog.cancel()
    }

    open fun showPackageActivatedDialog() {
        val alertDialog = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(
            R.layout.package_activation_successful_dialog,
            null
        )
        val tvPackageActivationSuccessful: TextView =
            view.findViewById(R.id.tvPackageActivationSuccessful)
        tvPackageActivationSuccessful.text =
            "${viewModel.subscriptionData.value?.packageType} ${resources.getString(R.string.activated_successfully)}"
        alertDialog.apply {
            setView(view)
            setPositiveButton("Ok") { _, _ ->
            }
        }.create().show()
    }

    private fun showTransactionFailedDialog(packageType: String) {
        val alertDialog = AlertDialog.Builder(this)
        val view = this.layoutInflater.inflate(R.layout.package_activation_failed_dialog, null)
        val tvFailedMessage: TextView = view.findViewById(R.id.tvPackageActivationFailed)
        tvFailedMessage.text =
            "${resources.getString(R.string.failed_to_activate_package)} ${viewModel.subscriptionData.value?.packageType} "
        alertDialog.apply {
            setView(view)
            setPositiveButton("Ok") { _, _ ->
            }
        }.create().show()
    }

    private fun activateUserPackage() {
        viewModel.activateSubjectPackage()
    }

    fun getActivatedPackageIndex(): LiveData<Int> {
        return viewModel.getIndexOfActivatedPackage()
    }

    override fun onPayButtonClicked(subscriptionFormData: SubscriptionFormData) {
        showProcessingRequestDialog()
        viewModel.pay(subscriptionFormData)
    }

    private fun resetMomoPayService() {
        viewModel.restMomoPayService()
    }

    fun setSubjectPackageDataToActivate(position: Int, subjectPackageData: SubjectPackageData){
        viewModel.setSubjectPackageDataToActivate(subjectPackageData)
        showSubscriptionForm(position, subjectPackageData.subjectName!!)
    }

    fun getActivatedSubjectPackageData(): SubjectPackageData{
        return viewModel.subjectPackageDataToActivated.value!!
    }

    @SuppressLint("HardwareIds")
    fun getMobileID(): String {
        return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
    }
}