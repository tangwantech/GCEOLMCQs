package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.datamodels.SubjectAndFileNameData
import com.example.gceolmcq.datamodels.SubjectAndFileNameDataListModel
import com.example.gceolmcq.datamodels.SubjectPackageData
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

//    private lateinit var subjectFileNameDataList: ArrayList<String>

    private val _areSubjectsPackageDataAvailable = MutableLiveData<Boolean?>()
    val areSubjectsPackageDataAvailable: LiveData<Boolean?> = _areSubjectsPackageDataAvailable

    private val mutableSubjectPackageDataList = MutableLiveData<ArrayList<SubjectPackageData>?>()
    val subjectsPackageDataList:LiveData<ArrayList<SubjectPackageData>?> = mutableSubjectPackageDataList

    private val _activatedPackageIndex = MutableLiveData<Int>()
    val activatedPackageIndex: LiveData<Int> = _activatedPackageIndex

    private val _activatedPackageIndexChangedAt = MutableLiveData<Int>()
    val activatedPackageIndexChangedAt: LiveData<Int> = _activatedPackageIndexChangedAt

    private val _remoteRepoErrorMessage = MutableLiveData<String>()
    val remoteRepoErrorMessage: LiveData<String> = _remoteRepoErrorMessage



    fun setMobileId(mobileID: String) {
        this.mobileId = mobileID
    }

//    fun setSubjectNameList(subjectNames: ArrayList<String>) {
//        this.subjectNames = subjectNames
//    }

    fun initSubjectDataBase(gceOLMcqDatabase: GceOLMcqDatabase) {
        this.localDatabase = gceOLMcqDatabase
    }

//    private fun insertUserSubjectsPackageDataToLocalDB(subjectPackageDataList: List<SubjectPackageData>?){
//        subjectPackageDataList?.let {
//            viewModelScope.launch(Dispatchers.IO) {
//                localDatabase.subjectPackageDao().deleteAll()
//                mutableSubjectPackageDataList.value!!.forEach {
//                    localDatabase.subjectPackageDao().insert(it)
//                }
//                println("saving to local database complete")
//                readSubjectsPackageDataFromLocalDb()
//            }
//        }
//    }

//    fun readSubjectsPackageDataFromLocalDb() {
//
//        viewModelScope.launch(Dispatchers.IO) {
//            val tempSubjectPackageDataList =
//                localDatabase.subjectPackageDao().getAllSubjectsPackages()
//            if(tempSubjectPackageDataList.isNotEmpty()){
//                withContext(Dispatchers.Main) {
//                    println("Reading from db within main activity")
//                    val packageDataList = ArrayList<SubjectPackageData>()
//                    val expiryDataList = ArrayList<String>()
//                    tempSubjectPackageDataList.forEach {
//                        packageDataList.add(it)
//                        expiryDataList.add(it.expiresOn!!)
//                    }
//                   setSubjectsPackageDataList(packageDataList)
//                    println("Reading from db within main activity complete: $packageDataList")
//
//                }
//            }
//
//        }
//    }

    private fun updateActivatedSubjectPackageDataInLocalDatabase(
        position: Int,
        subjectPackageData: SubjectPackageData
    ) {
        viewModelScope.launch(Dispatchers.IO) {

            localDatabase.subjectPackageDao().update(subjectPackageData)
            _activatedPackageIndex.postValue(position)
        }
    }

//    private fun insertUserSubjectsPackageDataToRemoteRepo(subjectPackageDataList: List<SubjectPackageData>?){
//
//        subjectPackageDataList?.let {
//            if(userRemoteParseObject.value == null){
//                userRemoteParseObject.value = ParseObject(MCQConstants.BACK4APP_PACKAGE_NAME)
//            }
//            val jsonArray = JSONArray()
//            subjectPackageDataList.forEachIndexed { _, subjectPackageData ->
//                val jsonObject = JSONObject()
//                jsonObject.apply {
//                    put(MCQConstants.PACKAGE_INDEX, subjectPackageData.packageIndex)
//                    put(MCQConstants.SUBJECT_NAME, subjectPackageData.subjectName)
//                    put(MCQConstants.PACKAGE_NAME, subjectPackageData.packageName)
//                    put(MCQConstants.ACTIVATED_ON, subjectPackageData.activatedOn)
//                    put(MCQConstants.EXPIRES_ON, subjectPackageData.expiresOn)
//                }
//                jsonArray.put(jsonObject)
//
//            }
//
//            userRemoteParseObject.value?.put(MCQConstants.MOBILE_ID, mobileId!!)
//            userRemoteParseObject.value?.put(MCQConstants.SUBJECTS_PACKAGES, jsonArray)
//
//            userRemoteParseObject.value?.saveInBackground {
//                println("Saving......")
//                if (it == null) {
//                    readSubjectsPackagesByMobileIdFromRemoteRepo()
//                } else {
//                    _remoteRepoErrorMessage.value = it.localizedMessage
//                }
//            }
////
//
//
//
//        }
//    }

//    fun readSubjectsPackagesByMobileIdFromRemoteRepo() {
////        println("Query back4app")
//        val query: ParseQuery<ParseObject> = ParseQuery(MCQConstants.BACK4APP_PACKAGE_NAME)
//
//        query.whereEqualTo(MCQConstants.MOBILE_ID, mobileId)
//        query.findInBackground { objects, e ->
//            val packageDataList = ArrayList<SubjectPackageData>()
//            val expiryDataList = ArrayList<String>()
//            println("ParseObjects: $objects")
//            if (e == null) {
//
//                if (objects.isNotEmpty()) {
//                    userRemoteParseObject.value = objects[0].takeIf { parseObject -> parseObject.containsKey(MCQConstants.MOBILE_ID) }
//
//                    val jsonArraySubjectPackages: JSONArray? =
//                        userRemoteParseObject.value!!.getJSONArray("jsonArraySubjectPackages")
//                    for (index in 0 until jsonArraySubjectPackages!!.length()) {
//
//                        val jsonObject = jsonArraySubjectPackages.getJSONObject(index)
//
//                        val subjectPackageData = SubjectPackageData(
//                            packageIndex = jsonObject.getInt(MCQConstants.PACKAGE_INDEX),
//                            subjectName = jsonObject.getString(MCQConstants.SUBJECT_NAME),
//                            packageName = jsonObject.getString(MCQConstants.PACKAGE_NAME),
//                            activatedOn = jsonObject.getString(MCQConstants.ACTIVATED_ON),
//                            expiresOn = jsonObject.getString(MCQConstants.EXPIRES_ON)
//                        )
//                        packageDataList.add(subjectPackageData)
//                        expiryDataList.add(subjectPackageData.expiresOn!!)
//
//                    }
//                    println("querying back4App $packageDataList")
//                    syncSubjectPackageList(packageDataList, expiryDataList)
////                    setLocalInitData(packageDataList, expiryDataList, true)
//
////                    initializeSubjectPackageDataFromLocalDb()
//
////
//
//                } else {
//                    println("back4App data list is empty")
//                    activateTrialPackageForAllSubjectsAvailable()
////
//
//                }
//
//            } else {
////                println("exception.... ${e.localizedMessage}")
//                _remoteRepoErrorMessage.value = e.localizedMessage
//                setSubjectsPackageDataList(null)
//
//
//            }
//        }
//    }

    private fun updateUserSubjectsPackageDataListAtMobileIdInRemoteRepo(subjectPackageDataList: List<SubjectPackageData>?) {
        subjectPackageDataList?.let {
            val query: ParseQuery<ParseObject> = ParseQuery(MCQConstants.BACK4APP_PACKAGE_NAME)
            query.whereContains("mobileId", mobileId)
            query.limit = 1
            query.findInBackground { objects, e ->
                if (e == null) {
                    val parseObject = objects[0]
                    val jsonArray = JSONArray()
                    subjectPackageDataList.forEachIndexed { _, subjectPackageData ->
                        val jsonObject = JSONObject()
                        jsonObject.apply {
                            put(MCQConstants.PACKAGE_INDEX, subjectPackageData.packageIndex)
                            put(MCQConstants.SUBJECT_NAME, subjectPackageData.subjectName)
                            put(MCQConstants.PACKAGE_NAME, subjectPackageData.packageName)
                            put(MCQConstants.ACTIVATED_ON, subjectPackageData.activatedOn)
                            put(MCQConstants.EXPIRES_ON, subjectPackageData.expiresOn)
                        }
                        jsonArray.put(jsonObject)

                    }
                    parseObject.put(MCQConstants.MOBILE_ID, mobileId!!)
                    parseObject.put(MCQConstants.SUBJECTS_PACKAGES, jsonArray)
                    parseObject.saveInBackground {
                        if (it == null) {
                            println("Updated successfully")
//                                return@saveInBackground
                        } else {
                            _remoteRepoErrorMessage.value = it.localizedMessage
                            println("Update failed")
                        }
                    }
                }
            }
        }

    }

    private fun setSubjectsPackageDataList(packageDataList: ArrayList<SubjectPackageData>?){
        mutableSubjectPackageDataList.value = packageDataList
        _areSubjectsPackageDataAvailable.value = packageDataList?.isNotEmpty()
    }

//    fun setSubjectFileNameList(subjectFileNameList: ArrayList<String>) {
////        this.subjectFileNameDataList = subjectFileNameList
//    }

    fun getSubjectAndFileNameDataAt(position: Int): SubjectAndFileNameData {
//        return SubjectAndFileNameData(subjectNames[position], subjectFileNameDataList[position])
        return subjectAndFileNameDataListModel.subjectAndFileNameDataList[position]
    }

//    private fun activateTrialPackageForAllSubjectsAvailable(){
//        val activationExpiryDates =
//            ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
//                ActivationExpiryDatesGenerator.HOURS,
//                MCQConstants.TRIAL_DURATION
//            )
//        val packageDataList = ArrayList<SubjectPackageData>()
//        val expiryDataList = ArrayList<String>()
//        _liveSubjectsAvailable.value?.forEachIndexed { index, subject ->
//
//            packageDataList.add(
//                SubjectPackageData(
//                    index,
//                    subject,
//                    "TRIAL",
//                    activationExpiryDates.activatedOn,
//                    activationExpiryDates.expiresOn
//                )
//            )
////            expiryDataList.add(activationExpiryDates.expiresOn)
//
//        }
//        insertUserSubjectsPackageDataToRemoteRepo(packageDataList)
//    }

    fun activateSubjectPackageAt(subjectIndex: Int, packageType: String, packageDuration: Int) {
        val activationExpiryDates =
            ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                ActivationExpiryDatesGenerator.HOURS,
                packageDuration
            )
        mutableSubjectPackageDataList.value!![subjectIndex].apply {
            packageIndex = subjectIndex
            packageName = packageType
            activatedOn = activationExpiryDates.activatedOn
            expiresOn = activationExpiryDates.expiresOn
        }

        updateUserSubjectsPackageDataListAtMobileIdInRemoteRepo(mutableSubjectPackageDataList.value!!)
        updateActivatedSubjectPackageDataInLocalDatabase(
            subjectIndex,
            mutableSubjectPackageDataList.value!![subjectIndex]
        )
    }

    fun updateActivatedPackageIndexChangedAt(position: Int){
        _activatedPackageIndexChangedAt.postValue(position)

    }

    fun getSubjectExpiryDataAt(position: Int): String {
        return mutableSubjectPackageDataList.value!![position].expiresOn!!
    }

    fun getSubjectPackageDataAt(position: Int): SubjectPackageData {
        return mutableSubjectPackageDataList.value!![position]

    }

    fun getSubjectNameAt(position: Int): String {
        return liveSubjectsAvailable.value!![position]
    }



    fun getActivatedPackageName(position: Int): String?{
        return mutableSubjectPackageDataList.value!![position].packageName
    }



    fun getPackageNameAt(position: Int): String {
        return mutableSubjectPackageDataList.value!![position].packageName!!
    }




//    private fun syncSubjectPackageList(
//        packageDataList: ArrayList<SubjectPackageData>,
//        expiryDataList: ArrayList<String>
//    ) {
//        if (_liveSubjectsAvailable.value!!.size > packageDataList.size) {
//            val activationExpiryDates =
//                ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
//                    ActivationExpiryDatesGenerator.HOURS,
//                    MCQConstants.TRIAL_DURATION
//                )
//            for (index in packageDataList.size until _liveSubjectsAvailable.value!!.size) {
//
//                val subjectPackageData = SubjectPackageData(
//                    index,
//                    _liveSubjectsAvailable.value!![index],
//                    "TRIAL",
//                    activationExpiryDates.activatedOn,
//                    activationExpiryDates.expiresOn
//                )
//
//                packageDataList.add(subjectPackageData)
//                expiryDataList.add(subjectPackageData.expiresOn!!)
////                insertSubjectPackageDataInDatabase(subjectPackageData)
//            }
//            insertUserSubjectsPackageDataToLocalDB(packageDataList)
//        }
//
//
//    }

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
//        println(tempSubjectNames)

        _liveSubjectsAvailable.value = tempSubjectNames
    }

//    fun getSubjectNames(): String{
//        return _liveSubjectsAvailable.value
//    }


}

