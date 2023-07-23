package com.example.gceolmcq.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.MomoPayService
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.datamodels.SubscriptionFormData
import com.example.gceolmcq.datamodels.TransactionStatus
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject


class SubscriptionActivityViewModel: ViewModel() {
    private lateinit var momoPay: MomoPayService
    private var mobileId: String? = null
    private var userRemoteParseObject = MutableLiveData<ParseObject?>(null)
    private lateinit var localDatabase: GceOLMcqDatabase
    private val _subjectPackageDataToActivated = MutableLiveData<SubjectPackageData?>()
    val subjectPackageDataToActivated: LiveData<SubjectPackageData?> = _subjectPackageDataToActivated
    private val _activatedPackageIndexChangedAt = MutableLiveData<Int>()
    val activatedPackageIndexChangedAt: LiveData<Int> = _activatedPackageIndexChangedAt
    private val _subscriptionData = MutableLiveData<SubscriptionFormData>()
    val subscriptionData: LiveData<SubscriptionFormData> = _subscriptionData
    private val _remoteRepoErrorMessage = MutableLiveData<String>()
    val remoteRepoErrorMessage: LiveData<String> = _remoteRepoErrorMessage

    fun setSubjectPackageDataToActivate(packageData: SubjectPackageData){
        _subjectPackageDataToActivated.value = packageData
    }

    fun setMomoPayService(momoPayService: MomoPayService){
        momoPay = momoPayService
    }

    fun setMobileId(mobileID: String) {
        this.mobileId = mobileID
    }

    fun initSubjectDataBase(context: Context) {
        this.localDatabase = GceOLMcqDatabase.getDatabase(context)
    }

    private fun setSubscriptionData(subscriptionFormData: SubscriptionFormData){
        _subscriptionData.value = subscriptionFormData
    }

    fun activateSubjectPackageAt(subjectIndex: Int, packageType: String, packageDuration: Int) {
        val activationExpiryDates =
            ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                MCQConstants.MINUTES,
                packageDuration
            )
        _subjectPackageDataToActivated.value?.apply {
            packageIndex = subjectIndex
            packageName = packageType
            activatedOn = activationExpiryDates.activatedOn
            expiresOn = activationExpiryDates.expiresOn
        }

        updateActivatedPackageInRemoteRepo(_subjectPackageDataToActivated.value!!, subjectIndex)

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

    private fun readSubjectsPackagesByMobileIdFromRemoteRepo(position: Int) {
        val query: ParseQuery<ParseObject> = ParseQuery(MCQConstants.BACK4APP_PACKAGE_NAME)
        query.whereEqualTo(MCQConstants.MOBILE_ID, mobileId)
        println(query)
        query.findInBackground { objects, e ->
            val packageDataList = ArrayList<SubjectPackageData>()
            if (e == null) {
                userRemoteParseObject.value = objects[0]

                val jsonArraySubjectPackages: JSONArray? =
                    userRemoteParseObject.value!!.getJSONArray(MCQConstants.SUBJECTS_PACKAGES)
                for (index in 0 until jsonArraySubjectPackages!!.length()) {

                    val jsonObject = jsonArraySubjectPackages.getJSONObject(index)

                    val subjectPackageData = SubjectPackageData(
                        packageIndex = jsonObject.getInt(MCQConstants.PACKAGE_INDEX),
                        subjectName = jsonObject.getString(MCQConstants.SUBJECT_NAME),
                        packageName = jsonObject.getString(MCQConstants.PACKAGE_NAME),
                        activatedOn = jsonObject.getString(MCQConstants.ACTIVATED_ON),
                        expiresOn = jsonObject.getString(MCQConstants.EXPIRES_ON)
                    )
                    packageDataList.add(subjectPackageData)

                }

                insertUserSubjectsPackageDataToLocalDB(packageDataList, position)

            } else {
                _remoteRepoErrorMessage.value = e.localizedMessage
//                _areSubjectsPackageDataAvailable.value = false
            }
        }
    }

    private fun updateActivatedPackageInRemoteRepo(subjectPackageData: SubjectPackageData, position: Int){
        val query: ParseQuery<ParseObject> = ParseQuery(MCQConstants.BACK4APP_PACKAGE_NAME)
        query.whereContains(MCQConstants.MOBILE_ID, mobileId)
        query.limit = 1
        query.findInBackground { objects, e ->
            if (e == null) {
                val parseObject = objects[0]
                val jsonArray = JSONArray()
                val jsonObject = JSONObject()
                jsonObject.apply {
                    put(MCQConstants.PACKAGE_INDEX, subjectPackageData.packageIndex)
                    put(MCQConstants.SUBJECT_NAME, subjectPackageData.subjectName)
                    put(MCQConstants.PACKAGE_NAME, subjectPackageData.packageName)
                    put(MCQConstants.ACTIVATED_ON, subjectPackageData.activatedOn)
                    put(MCQConstants.EXPIRES_ON, subjectPackageData.expiresOn)
                }
                jsonArray.put(jsonObject)

//                parseObject.put(MCQConstants.MOBILE_ID, mobileId!!)
                parseObject.put(MCQConstants.SUBJECTS_PACKAGES, jsonArray)
                parseObject.saveInBackground {
                    if (it == null) {
                        println("Updated successfully")
                        readSubjectsPackagesByMobileIdFromRemoteRepo(position)
                    } else {
                        _remoteRepoErrorMessage.value = it.localizedMessage
                        println("Update failed")
                    }
                }
            }
        }
    }

    private fun insertUserSubjectsPackageDataToLocalDB(tempSubjectPackageDataList: List<SubjectPackageData>?, position: Int){
        tempSubjectPackageDataList?.let {subjectPackageDataList ->

            viewModelScope.launch(Dispatchers.IO) {
                localDatabase.subjectPackageDao().deleteAll()
                subjectPackageDataList.forEach {
                    println("inserting to database")
                    localDatabase.subjectPackageDao().insert(it)
                    updateActivatedPackageIndexChangedAt(position)

                }

            }
        }
    }
}
