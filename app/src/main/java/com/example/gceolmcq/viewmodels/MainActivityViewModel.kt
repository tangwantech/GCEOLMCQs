package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.MomoPayService
import com.example.gceolmcq.datamodels.*
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.google.gson.Gson
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

//private const val BACK4APP_PACKAGE_NAME = "MCQPackages"
//private const val SUBJECT_NAME = "subjectName"
//private const val PACKAGE_NAME = "packageName"
//private const val ACTIVATED_ON = "activatedOn"
//private const val EXPIRES_ON = "expiresOn"
//private const val MOBILE_ID = "mobileId"
//private const val PACKAGE_INDEX = "packageIndex"
//private const val JSON_ARRAY_SUBJECT_PACKAGES = "jsonArraySubjectPackages"

class MainActivityViewModel : ViewModel() {
    private var mobileId: String? = null

    private lateinit var localDatabase: GceOLMcqDatabase

    private var userRemoteParseObject = MutableLiveData<ParseObject?>(null)

//    private lateinit var subjectNames: ArrayList<String>

    private val _liveSubjectsAvailable = MutableLiveData<ArrayList<String>>()
    val liveSubjectsAvailable: LiveData<ArrayList<String>> = _liveSubjectsAvailable

    private lateinit var subjectAndFileNameDataListModel: SubjectAndFileNameDataListModel

    private val _areSubjectsPackageDataAvailable = MutableLiveData<Boolean?>()
    val areSubjectsPackageDataAvailable: LiveData<Boolean?> = _areSubjectsPackageDataAvailable

    private val _subjectPackageDataToActivated = MutableLiveData<SubjectPackageData?>()

    private val _activatedPackageIndex = MutableLiveData<Int>()
    val activatedPackageIndex: LiveData<Int> = _activatedPackageIndex

    private val _activatedPackageIndexChangedAt = MutableLiveData<Int>()
    val activatedPackageIndexChangedAt: LiveData<Int> = _activatedPackageIndexChangedAt

    private val _remoteRepoErrorMessage = MutableLiveData<String>()
    val remoteRepoErrorMessage: LiveData<String> = _remoteRepoErrorMessage

    private val _subscriptionData = MutableLiveData<SubscriptionFormData>()
    val subscriptionData: LiveData<SubscriptionFormData> = _subscriptionData

    val momoPay = MomoPayService()




    fun setMobileId(mobileID: String) {
        this.mobileId = mobileID
    }

    fun initSubjectDataBase(gceOLMcqDatabase: GceOLMcqDatabase) {
        this.localDatabase = gceOLMcqDatabase
    }

    private fun updateActivatedSubjectPackageDataInLocalDatabase(
        position: Int,
        subjectPackageData: SubjectPackageData
    ) {
        viewModelScope.launch(Dispatchers.IO) {

            localDatabase.subjectPackageDao().update(subjectPackageData)
            _activatedPackageIndex.postValue(position)
        }
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
        query.whereContains("mobileId", mobileId)
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

    fun setSubjectPackageDataToActivate(packageData: SubjectPackageData){
        _subjectPackageDataToActivated.value = packageData
    }


    fun getSubjectAndFileNameDataAt(position: Int): SubjectAndFileNameData {
//        return SubjectAndFileNameData(subjectNames[position], subjectFileNameDataList[position])
        return subjectAndFileNameDataListModel.subjectAndFileNameDataList[position]
    }

    fun activateSubjectPackageAt(subjectIndex: Int, packageType: String, packageDuration: Int) {
        val activationExpiryDates =
            ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                ActivationExpiryDatesGenerator.MINUTES,
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

    fun updateActivatedPackageIndexChangedAt(position: Int){
        println("Updating activated package index")
        _activatedPackageIndexChangedAt.postValue(position)
        println(_activatedPackageIndexChangedAt.value)

    }

    fun getSubjectNameAt(position: Int): String {
        return liveSubjectsAvailable.value!![position]
    }

    fun setSubjectAndFileNameDataListModel(subjectsDataJsonString: String?) {
        subjectAndFileNameDataListModel =
            Gson().fromJson(subjectsDataJsonString!!, SubjectAndFileNameDataListModel::class.java)
        val subjectAndFile = subjectAndFileNameDataListModel.subjectAndFileNameDataList
        setSubjectNames(subjectAndFile)

    }

    private fun setSubjectNames(temp: ArrayList<SubjectAndFileNameData>) {
        val tempSubjectNames = ArrayList<String>()
        temp.forEach {
            tempSubjectNames.add(it.subject)
        }

        _liveSubjectsAvailable.value = tempSubjectNames
    }

    private fun setSubscriptionData(subscriptionFormData: SubscriptionFormData){
        _subscriptionData.value = subscriptionFormData
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

}

