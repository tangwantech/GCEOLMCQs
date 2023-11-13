package com.example.gceolmcq.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.MomoPayService

import com.example.gceolmcq.SubjectPackageActivator
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.datamodels.SubscriptionFormData
import com.example.gceolmcq.datamodels.TransactionStatus

//import com.example.gceolmcq.momoPay.MomoPayService
import com.example.gceolmcq.repository.RepositoriesLinker


class SubscriptionActivityViewModel: ViewModel() {
    private lateinit var momoPay: MomoPayService
    private lateinit var momoPay2: com.example.gceolmcq.momoPay.MomoPayService
    private var mobileId: String? = null


//    private lateinit var localDatabase: GceOLMcqDatabase

    private val _subjectPackageDataToActivated = MutableLiveData<SubjectPackageData?>()
    val subjectPackageDataToActivated: LiveData<SubjectPackageData?> = _subjectPackageDataToActivated

    private val _activatedPackageIndexChangedAt = MutableLiveData<Int>()
    val activatedPackageIndexChangedAt: LiveData<Int> = _activatedPackageIndexChangedAt

    private val _subscriptionData = MutableLiveData<SubscriptionFormData>()
    val subscriptionData: LiveData<SubscriptionFormData> = _subscriptionData

    private lateinit var repositoriesLinker: RepositoriesLinker
    private val transactionStatus = MutableLiveData<String?>()



    fun setSubjectPackageDataToActivate(packageData: SubjectPackageData){
        _subjectPackageDataToActivated.value = packageData
    }

    fun setRepositoryLink(context: Context, mobileId: String){
        repositoriesLinker = RepositoriesLinker().apply {
            setLocalRepo(context, mobileId)
        }
    }
    fun getAreSubjectsPackagesAvailable(): LiveData<Boolean?>{
        return repositoriesLinker.getAreSubjectsPackagesAvailable()
    }

    fun getIndexOfActivatedPackage():LiveData<Int>{
        return repositoriesLinker.getIndexOfActivatedPackage()
    }

    fun getRemoteRepoErrorEncountered():LiveData<Boolean>{
        return repositoriesLinker.getRemoteRepository().remoteRepoErrorExceptionRaised
    }

    fun setMomoPayService(momoPayService: MomoPayService){
        momoPay = momoPayService

    }

    fun setMobileId(mobileID: String) {
        this.mobileId = mobileID
    }

    fun setSubscriptionData(subscriptionFormData: SubscriptionFormData){
        _subscriptionData.value = subscriptionFormData
    }

    fun activateSubjectPackage() {
        val subjectIndex = _subscriptionData.value?.subjectPosition!!
        val subjectName = _subscriptionData.value?.subject!!
        val packageType = _subscriptionData.value?.packageType!!
        val packageDuration = _subscriptionData.value?.packageDuration!!
        val activatedSubjectPackage = SubjectPackageActivator.activateSubjectPackage(subjectName, subjectIndex, packageType, packageDuration)
        updateActivatedPackageInRemoteRepo(activatedSubjectPackage, subjectIndex)

    }

    fun activateSubjectTrialPackage(subjectIndex: Int, subjectName: String){
        val subscriptionForm = SubscriptionFormData(
            subjectPosition = subjectIndex,
            subject = subjectName,
            packageType = MCQConstants.TRIAL,
            packageDuration = MCQConstants.TRIAL_DURATION
        )
        _subscriptionData.value = subscriptionForm
        activateSubjectPackage()
        
    }
    private fun updateActivatedPackageIndexChangedAt(position: Int){
        _activatedPackageIndexChangedAt.postValue(position)

    }



    fun initiatePayment(){
//        setSubscriptionData(subscriptionFormData)
        println("Pay")
        momoPay.initiatePayment(subscriptionData.value!!)

    }

    fun getTransactionStatus(): LiveData<TransactionStatus>{
        return momoPay.getTransactionStatus()
    }

    fun isTransactionSuccessful(): LiveData<Boolean?>{
        return momoPay.getIsTransactionSuccessful()
    }


    fun restMomoPayService() {
        momoPay.reset()
//        momoPay = null

    }

    fun getIsPaymentSystemAvailable():LiveData<Boolean?>{
        return momoPay.isPaymentSystemAvailable
    }

    private fun updateActivatedPackageInRemoteRepo(subjectPackageData: SubjectPackageData, position: Int){
        repositoriesLinker.getRemoteRepository().updateActivatedPackageInRemoteRepo(subjectPackageData, position)
    }

    fun loadSubjectPackageDataFromLocalDbWhere(subjectName: String){
        repositoriesLinker.getLocalRepository().getSubjectPackageDataFromLocalDbWhereSubjectName(subjectName)
    }

    fun checkSubjectPackageExpiry(): Boolean{
        val activatedOn = repositoriesLinker.getLocalRepository().subjectPackageData.value?.activatedOn!!
        val expiresOn = repositoriesLinker.getLocalRepository().subjectPackageData.value?.expiresOn!!
        return ActivationExpiryDatesGenerator().checkExpiry(activatedOn, expiresOn)
    }

    fun getSubjectPackageData(): SubjectPackageData{
        return repositoriesLinker.getLocalRepository().subjectPackageData.value!!
    }


    fun initMomoPay2(momoPayService2: com.example.gceolmcq.momoPay.MomoPayService){
        momoPay2 = momoPayService2
    }

    fun testPay(){
//        momoPay2 = momoPayService2
        momoPay2.testPaySuccessful()
    }

    fun pay(){
        momoPay2.pay(this.subscriptionData.value!!)
    }

    fun generateToken( momoPayService2: com.example.gceolmcq.momoPay.MomoPayService){
        momoPay2 = momoPayService2
        momoPay2.apply {
            generateToken()
        }

    }

    fun getToken(): LiveData<String?>{
        return momoPay2.getToken()
    }

    fun getTransactionId(): LiveData<String?>{
        return momoPay2.getTransactionId()
    }

    fun getTransactionStatusChanged(): LiveData<String?>{
        return momoPay2.getTransactionStatusChanged()
    }

    fun getIsTransactionIdAvailable(): LiveData<Boolean?>{
        return momoPay2.getIsTransactionIdAvailable()
    }



    fun checkTransactionStatus(){
        momoPay2.checkTransactionStatus()
    }
}
