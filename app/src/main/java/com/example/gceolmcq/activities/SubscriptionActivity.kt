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

//import com.example.gceolmcq.momoPay.MomoPayService
import com.example.gceolmcq.viewmodels.SubscriptionActivityViewModel
import kotlinx.coroutines.*

abstract class SubscriptionActivity: AppCompatActivity(), SubscriptionFormDialogFragment.OnPayButtonClickListener{

    private var processingAlertDialog: AlertDialog? = null
    private var requestToPayDialog: AlertDialog? = null
    private var failedToActivatePackageDialog: AlertDialog? = null
    private var activatingPackageDialog: AlertDialog? = null
    private var packageActivatedDialog: AlertDialog? = null
    private var paymentReceivedDialog: AlertDialog? = null
    private var activatingTrialPackageDialog: AlertDialog? = null

    private lateinit var viewModel: SubscriptionActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
        setupViewObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[SubscriptionActivityViewModel::class.java]
        viewModel.setRepositoryLink(this, getMobileID())
        viewModel.setMobileId(getMobileID())
        viewModel.setMomoPayService(MomoPayService(this))
        viewModel.initMomoPay2(com.example.gceolmcq.momoPay.MomoPayService(this))
    }

    private fun setupViewObservers() {
        viewModel.getAreSubjectsPackagesAvailable().observe(this){areAvailable ->

            areAvailable?.let{
                if (it){
                    if(activatingPackageDialog != null){
                        cancelActivatingPackageDialog()
                    }
                    if (activatingTrialPackageDialog != null){
                        dismissActivatingTrialPackageDialog()
                    }
                    if (packageActivatedDialog == null){
                        showPackageActivatedDialog()
                    }

                }

            }

        }

        viewModel.getRemoteRepoErrorEncountered().observe(this){
            println("Error encountered: $it")
        }


        setMomoPayFlow1()

//        setupMomoPayFlow2()

    }

    private fun setMomoPayFlow1(){
        viewModel.getTransactionStatus().observe(this) {

            it.status?.let{status ->
                when(status) {
                    MCQConstants.PENDING -> {
                        if (processingAlertDialog != null){
                            cancelProcessingRequestDialog()
                        }
                        if (failedToActivatePackageDialog != null){
                            cancelFailedToActivateDialog()
                        }

                        if (requestToPayDialog == null){
                            showRequestUserToPayDialog()
                        }



                    }
                    MCQConstants.SUCCESSFUL -> {
                        cancelProcessingAndRequestToPayDialogs()
                        if(paymentReceivedDialog == null){
                            showPaymentReceivedDialog()
                        }

                        CoroutineScope(Dispatchers.IO).launch {
                            delay(2000)
                            withContext(Dispatchers.Main){
                                if(paymentReceivedDialog != null){
                                    cancelPaymentReceivedDialog()
                                }
                                if(activatingPackageDialog == null){
                                    showActivatingPackageDialog()
                                    activateUserPackage()
                                }
                            }
                        }
                    }
                    MCQConstants.FAILED -> {
                        cancelProcessingAndRequestToPayDialogs()
                        if(failedToActivatePackageDialog == null){
                            showTransactionFailedDialog()
                            resetMomoPayService()
                        }
                    }
                }
            }


        }

        viewModel.getIsPaymentSystemAvailable().observe(this){isPaymentSystemAvailable ->
            isPaymentSystemAvailable?.let {
                if(!it){
                    Toast.makeText(this, "Payment system is temporarily unavailable. Please try again later", Toast.LENGTH_LONG).show()
                }
            }
        }
    }



    private fun setupMomoPayFlow2(){
        viewModel.getToken().observe(this){token ->
            println("is token available.....")
            if(token != null){
                if (processingAlertDialog != null){
                    cancelProcessingRequestDialog()
                }
                viewModel.pay()

            }else{
                if (processingAlertDialog != null){
                    cancelProcessingRequestDialog()
                }
                if(failedToActivatePackageDialog == null){
                    showTransactionFailedDialog()
                    resetMomoPayService()
                }

            }
        }
        viewModel.getTransactionId().observe(this){transactionId ->
            if(transactionId != null){
                if (requestToPayDialog == null){
                    showRequestUserToPayDialog()
                }
                viewModel.checkTransactionStatus()
            }else{
                if(failedToActivatePackageDialog == null){
                    showTransactionFailedDialog()
                    resetMomoPayService()
                }
            }
        }
        viewModel.getTransactionStatusChanged().observe(this){transactionStatus ->
            println(transactionStatus)
            if (transactionStatus != null){
                when(transactionStatus) {
//                    MCQConstants.PENDING -> {
//                        if (processingAlertDialog != null){
//                            cancelProcessingRequestDialog()
//                        }
//
//                        if (requestToPayDialog == null){
//                            showRequestUserToPayDialog()
//                        }
//
//
//
//                    }
                    MCQConstants.SUCCESSFUL -> {
                        cancelProcessingAndRequestToPayDialogs()
                        if(paymentReceivedDialog == null){
                            showPaymentReceivedDialog()
                        }

                        CoroutineScope(Dispatchers.IO).launch {
                            delay(2000)
                            withContext(Dispatchers.Main){
                                if(paymentReceivedDialog != null){
                                    cancelPaymentReceivedDialog()
                                }
                                if(activatingPackageDialog == null){
                                    showActivatingPackageDialog()
                                    activateUserPackage()
                                }
                            }
                        }
                    }
                    MCQConstants.FAILED -> {
                        cancelProcessingAndRequestToPayDialogs()
                        if(failedToActivatePackageDialog == null){
                            showTransactionFailedDialog()
                            resetMomoPayService()
                        }
                    }
                }

            }else{
                cancelProcessingAndRequestToPayDialogs()
                Toast.makeText(this, "Failed to activate package due to no internet connection", Toast.LENGTH_LONG).show()
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
        processingAlertDialog = AlertDialog.Builder(this).create()
        processingAlertDialog?.apply {
            setCancelable(false)
        }
        processingAlertDialog?.setMessage(resources.getString(R.string.processing_request))
        processingAlertDialog?.show()
    }

    private fun cancelProcessingRequestDialog() {
        processingAlertDialog?.dismiss()
        processingAlertDialog = null
    }

    private fun showActivatingPackageDialog() {
        activatingPackageDialog = AlertDialog.Builder(this).create()
        activatingPackageDialog?.apply {
            setCancelable(false)
        }
        activatingPackageDialog?.setMessage(resources.getString(R.string.activating_package_message))
        activatingPackageDialog?.show()
//        activateUserPackage()
    }

    private fun cancelActivatingPackageDialog() {
        activatingPackageDialog?.dismiss()
        activatingPackageDialog = null
    }

    private fun showSubscriptionForm(position: Int, subjectName: String) {
        val subscriptionFormDialogFragment = SubscriptionFormDialogFragment.newInstance(
            position,
            subjectName
        )
        subscriptionFormDialogFragment.isCancelable = false
        subscriptionFormDialogFragment.show(supportFragmentManager, "subscription_form_dialog")
    }

    private fun showRequestUserToPayDialog() {

        val dialogView = layoutInflater.inflate(R.layout.fragment_request_to_pay, null)
        val tvRequestToPayMessage: TextView = dialogView.findViewById(R.id.tvRequestToPayMessage)
        val tvRequestToPaySubject: TextView =
            dialogView.findViewById(R.id.tvRequestToPaySubject)
        val tvRequestToPayPackageType: TextView =
            dialogView.findViewById(R.id.tvRequestToPayPackage)
        val tvRequestToPayPackagePrice: TextView =
            dialogView.findViewById(R.id.tvRequestToPayAmount)

        if (viewModel.subscriptionData.value?.momoPartner == "${resources.getStringArray(R.array.momo_partners)[0]}") {
            tvRequestToPayMessage.text = resources.getString(R.string.mtn_request_to_pay_message)
        } else {
            tvRequestToPayMessage.text = resources.getString(R.string.orange_request_to_pay_message)
        }

        tvRequestToPaySubject.text = viewModel.subscriptionData.value?.subject
        tvRequestToPayPackageType.text = viewModel.subscriptionData.value?.packageType
        tvRequestToPayPackagePrice.text = "${viewModel.subscriptionData.value?.packagePrice} FCFA"

        requestToPayDialog = AlertDialog.Builder(this).create()
        requestToPayDialog?.apply {
            setCancelable(false)
        }
        requestToPayDialog?.setView(dialogView)
        requestToPayDialog?.show()

    }

    private fun cancelRequestToPayDialog() {
//        requestToPayDialog.cancel()
        requestToPayDialog?.dismiss()
        requestToPayDialog =  null
    }

    private fun cancelProcessingAndRequestToPayDialogs(){
        if(processingAlertDialog != null){
            cancelProcessingRequestDialog()
        }

        if(requestToPayDialog != null){
            cancelRequestToPayDialog()
        }
    }

    open fun showPackageActivatedDialog() {
        packageActivatedDialog = AlertDialog.Builder(this).create()
        val view = layoutInflater.inflate(
            R.layout.package_activation_successful_dialog,
            null
        )
        val tvPackageActivationSuccessful: TextView =
            view.findViewById(R.id.tvPackageActivationSuccessful)
        tvPackageActivationSuccessful.text =
            "${viewModel.subscriptionData.value?.packageType} ${resources.getString(R.string.activated_successfully)}"

        packageActivatedDialog?.setView(view)
        packageActivatedDialog?.setButton(AlertDialog.BUTTON_POSITIVE, "OK"){ _, _ ->
            packageActivatedDialog = null
        }
        packageActivatedDialog?.show()
    }

    private fun showTransactionFailedDialog() {

        failedToActivatePackageDialog = AlertDialog.Builder(this).create()
        val view = this.layoutInflater.inflate(R.layout.package_activation_failed_dialog, null)
        val tvFailedMessage: TextView = view.findViewById(R.id.tvPackageActivationFailed)
        tvFailedMessage.text =
            "${resources.getString(R.string.failed_to_activate_package)} ${viewModel.subscriptionData.value?.packageType} "

        failedToActivatePackageDialog?.setView(view)
        failedToActivatePackageDialog?.setButton(AlertDialog.BUTTON_POSITIVE, "Ok") { _, _ ->
//            d.dismiss()
            failedToActivatePackageDialog = null

        }
        failedToActivatePackageDialog?.show()

    }

    private fun cancelFailedToActivateDialog(){
        failedToActivatePackageDialog?.dismiss()
        failedToActivatePackageDialog = null
    }

    private fun showPaymentReceivedDialog(){
        paymentReceivedDialog = AlertDialog.Builder(this).create()
        paymentReceivedDialog?.setMessage(resources.getString(R.string.payment_received))
        paymentReceivedDialog?.show()
    }

    private fun cancelPaymentReceivedDialog(){
        paymentReceivedDialog?.dismiss()
        paymentReceivedDialog = null
    }

    fun showActivatingTrialPackageDialog(){
        activatingTrialPackageDialog = AlertDialog.Builder(this).create()
        activatingTrialPackageDialog?.setMessage("Activating trial package...")
        activatingTrialPackageDialog?.setCancelable(false)
        activatingTrialPackageDialog?.show()
    }

    fun dismissActivatingTrialPackageDialog(){
        activatingTrialPackageDialog?.dismiss()
        activatingTrialPackageDialog = null
    }

    private fun activateUserPackage() {
        viewModel.activateSubjectPackage()
    }

    fun activateTrialPackage(position: Int, subjectName: String){
        viewModel.activateSubjectTrialPackage(position, subjectName)
    }

    fun getActivatedPackageIndex(): LiveData<Int> {
        return viewModel.getIndexOfActivatedPackage()
    }

    override fun onPayButtonClicked(subscriptionFormData: SubscriptionFormData) {
        viewModel.setSubscriptionData(subscriptionFormData)
        showProcessingRequestDialog()
//        viewModel.generateToken(com.example.gceolmcq.momoPay.MomoPayService(this))
//        viewModel.testPay()

        viewModel.initiatePayment()
    }

    private fun resetMomoPayService() {
        viewModel.restMomoPayService()
        viewModel.initMomoPay2(com.example.gceolmcq.momoPay.MomoPayService(this))
    }

    fun setSubjectPackageDataToActivate(position: Int, subjectPackageData: SubjectPackageData){
        viewModel.setSubjectPackageDataToActivate(subjectPackageData)
        showSubscriptionForm(position, subjectPackageData.subjectName!!)
    }

    fun getActivatedSubjectPackageData(): SubjectPackageData{
        return viewModel.subjectPackageDataToActivated.value!!
    }

    fun loadSubjectPackageDataFromLocalDbWhere(subjectName: String){
        viewModel.loadSubjectPackageDataFromLocalDbWhere(subjectName)
    }

    fun getIsPackageActive(): Boolean{
        return viewModel.checkSubjectPackageExpiry()
    }

    fun getSubjectPackageData(): SubjectPackageData{
        return viewModel.getSubjectPackageData()
    }


    @SuppressLint("HardwareIds")
    fun getMobileID(): String {
        return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
    }
}