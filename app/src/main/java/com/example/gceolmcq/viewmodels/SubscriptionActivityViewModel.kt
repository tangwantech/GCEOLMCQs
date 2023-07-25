package com.example.gceolmcq.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.MomoPayService
import com.example.gceolmcq.SubjectPackageActivator
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.datamodels.SubscriptionFormData
import com.example.gceolmcq.datamodels.TransactionStatus
import com.example.gceolmcq.repository.RepositoriesLink
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.parse.ParseObject


class SubscriptionActivityViewModel: ViewModel() {
    private lateinit var momoPay: MomoPayService
    private var mobileId: String? = null

//    private lateinit var localDatabase: GceOLMcqDatabase

    private val _subjectPackageDataToActivated = MutableLiveData<SubjectPackageData?>()
    val subjectPackageDataToActivated: LiveData<SubjectPackageData?> = _subjectPackageDataToActivated

    private val _activatedPackageIndexChangedAt = MutableLiveData<Int>()
    val activatedPackageIndexChangedAt: LiveData<Int> = _activatedPackageIndexChangedAt

    private val _subscriptionData = MutableLiveData<SubscriptionFormData>()
    val subscriptionData: LiveData<SubscriptionFormData> = _subscriptionData

    private lateinit var repositoriesLink: RepositoriesLink



    fun setSubjectPackageDataToActivate(packageData: SubjectPackageData){
        _subjectPackageDataToActivated.value = packageData
    }

    fun setRepositoryLink(context: Context, mobileId: String){
        repositoriesLink = RepositoriesLink().apply {
            setLocalRepo(context, mobileId)
        }
    }
    fun getAreSubjectsPackagesAvailable(): LiveData<Boolean?>{
        return repositoriesLink.getAreSubjectsPackagesAvailable()
    }

    fun getIndexOfActivatedPackage():LiveData<Int>{
        return repositoriesLink.getIndexOfActivatedPackage()
    }

    fun getRemoteRepoErrorEncountered():LiveData<Boolean>{
        return repositoriesLink.getRemoteRepository().remoteRepoErrorEncountered
    }

    fun setMomoPayService(momoPayService: MomoPayService){
        momoPay = momoPayService
    }

    fun setMobileId(mobileID: String) {
        this.mobileId = mobileID
    }

//    fun initSubjectDataBase(context: Context) {
//        this.localDatabase = GceOLMcqDatabase.getDatabase(context)
//    }

    private fun setSubscriptionData(subscriptionFormData: SubscriptionFormData){
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
    private fun updateActivatedPackageIndexChangedAt(position: Int){
        _activatedPackageIndexChangedAt.postValue(position)

    }

    fun pay(subscriptionFormData: SubscriptionFormData){
        setSubscriptionData(subscriptionFormData)
        momoPay.initiatePayment(subscriptionFormData)
    }

    fun getTransactionStatus(): LiveData<TransactionStatus>{
        return momoPay.getTransactionStatus()
    }

    fun isTransactionSuccessful(): LiveData<Boolean>{
        return momoPay.getIsTransactionSuccessful()
    }


    fun restMomoPayService() {
        momoPay.reset()
    }

    private fun updateActivatedPackageInRemoteRepo(subjectPackageData: SubjectPackageData, position: Int){
        repositoriesLink.getRemoteRepository().updateActivatedPackageInRemoteRepo(subjectPackageData, position)
    }

    fun loadSubjectPackageDataFromLocalDbWhere(subjectName: String){
        repositoriesLink.getLocalRepository().getSubjectPackageDataFromLocalDbWhereSubjectName(subjectName)
    }

    fun checkSubjectPackageExpiry(): Boolean{
        return ActivationExpiryDatesGenerator().checkExpiry(repositoriesLink.getLocalRepository().subjectPackageData.value?.expiresOn!!)
    }

    fun getSubjectPackageData(): SubjectPackageData{
        return repositoriesLink.getLocalRepository().subjectPackageData.value!!
    }
}
