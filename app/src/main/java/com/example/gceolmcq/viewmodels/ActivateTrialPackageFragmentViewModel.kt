package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class ActivateTrialPackageFragmentViewModel: ViewModel() {
    private lateinit var localDatabase: GceOLMcqDatabase
    private var userRemoteParseObject = MutableLiveData<ParseObject?>(null)
    private val _remoteRepoErrorMessage = MutableLiveData<String>()
    val remoteRepoErrorMessage: LiveData<String> = _remoteRepoErrorMessage
    private var mobileId: String? = null
    private val _areSubjectsPackageDataAvailable = MutableLiveData<Boolean?>()
    val areSubjectsPackageDataAvailable: LiveData<Boolean?> = _areSubjectsPackageDataAvailable
    private val _liveSubjectsAvailable = MutableLiveData<List<String>>()
    val subjectsAvailable: LiveData<List<String>> = _liveSubjectsAvailable


    fun setSubjectDataBase(gceOLMcqDatabase: GceOLMcqDatabase) {
        this.localDatabase = gceOLMcqDatabase
    }

    fun setSubjectNames(subjectNames: List<String>) {
        _liveSubjectsAvailable.value = subjectNames
    }

    fun setMobileId(id: String){
        mobileId = id
    }

    private fun insertUserSubjectsPackageDataToRemoteRepo(subjectPackageDataList: List<SubjectPackageData>?){

        subjectPackageDataList?.let {
            if(userRemoteParseObject.value == null){
                userRemoteParseObject.value = ParseObject(MCQConstants.BACK4APP_PACKAGE_NAME)
            }
            val jsonArray = JSONArray()
            println(userRemoteParseObject.value)
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

            userRemoteParseObject.value?.put(MCQConstants.MOBILE_ID, mobileId!!)
            userRemoteParseObject.value?.put(MCQConstants.SUBJECTS_PACKAGES, jsonArray)

            userRemoteParseObject.value?.saveInBackground {
//                println("Saving......")
                if (it == null) {
                    readSubjectsPackagesByMobileIdFromRemoteRepo()
                } else {
                    _remoteRepoErrorMessage.value = it.localizedMessage
                }
            }
        }
    }

    fun readSubjectsPackagesByMobileIdFromRemoteRepo() {
        val query: ParseQuery<ParseObject> = ParseQuery(MCQConstants.BACK4APP_PACKAGE_NAME)
        query.whereEqualTo(MCQConstants.MOBILE_ID, mobileId)
        println(query)
        query.findInBackground { objects, e ->
            val packageDataList = ArrayList<SubjectPackageData>()
            val expiryDataList = ArrayList<String>()
//            println("ParseObjects: $objects")
            if (e == null) {

                if (objects.isNotEmpty()) {
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
                        expiryDataList.add(subjectPackageData.expiresOn!!)

                    }
//                    println("querying back4App $packageDataList")
                    syncSubjectPackageList(packageDataList, expiryDataList)

                } else {
//                    println("back4App data list is empty")
                    activateTrialPackageForAllSubjectsAvailable()

                }

            } else {
                _remoteRepoErrorMessage.value = e.localizedMessage
                _areSubjectsPackageDataAvailable.value = false
            }
        }
    }
    private fun syncSubjectPackageList(
        packageDataList: ArrayList<SubjectPackageData>,
        expiryDataList: ArrayList<String>
    ) {
        if (_liveSubjectsAvailable.value!!.size > packageDataList.size) {
            val activationExpiryDates =
                ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                    MCQConstants.MINUTES,
                    MCQConstants.TRIAL_DURATION
                )
            for (index in packageDataList.size until _liveSubjectsAvailable.value!!.size) {

                val subjectPackageData = SubjectPackageData(
                    index,
                    _liveSubjectsAvailable.value!![index],
                    "TRIAL",
                    activationExpiryDates.activatedOn,
                    activationExpiryDates.expiresOn
                )

                packageDataList.add(subjectPackageData)
                expiryDataList.add(subjectPackageData.expiresOn!!)
            }

        }
        insertUserSubjectsPackageDataToLocalDB(packageDataList)


    }

    private fun insertUserSubjectsPackageDataToLocalDB(tempSubjectPackageDataList: List<SubjectPackageData>?){
        tempSubjectPackageDataList?.let {subjectPackageDataList ->

            viewModelScope.launch(Dispatchers.IO) {
                localDatabase.subjectPackageDao().deleteAll()
                subjectPackageDataList.forEach {
                    localDatabase.subjectPackageDao().insert(it)
//                    println("inserting to database")
                }
                withContext(Dispatchers.Main){

                    _areSubjectsPackageDataAvailable.value = subjectPackageDataList.isNotEmpty()
                }

            }
        }
    }

    private fun activateTrialPackageForAllSubjectsAvailable(){
        val activationExpiryDates =
            ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                MCQConstants.MINUTES,
                MCQConstants.TRIAL_DURATION
            )

        val packageDataList = ArrayList<SubjectPackageData>()
//        val expiryDataList = ArrayList<String>()
        _liveSubjectsAvailable.value?.forEachIndexed { index, subject ->

            packageDataList.add(
                SubjectPackageData(
                    index,
                    subject,
                    "TRIAL",
                    activationExpiryDates.activatedOn,
                    activationExpiryDates.expiresOn,
                    isPackageActive = true
                )
            )

        }
        insertUserSubjectsPackageDataToRemoteRepo(packageDataList)
    }
}