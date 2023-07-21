package com.example.gceolmcq.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.MyNetworkTimeout
import com.example.gceolmcq.datamodels.SubjectAndFileNameDataListModel
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.datamodels.SubjectPackageDataList
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.google.gson.Gson
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

private const val BACK4APP_PACKAGE_NAME = "MCQPackages"
private const val SUBJECT_NAME = "subjectName"
private const val PACKAGE_NAME = "packageName"
private const val ACTIVATED_ON = "activatedOn"
private const val EXPIRES_ON = "expiresOn"
private const val MOBILE_ID = "mobileId"
private const val PACKAGE_INDEX = "packageIndex"
private const val JSON_ARRAY_SUBJECT_PACKAGES = "jsonArraySubjectPackages"
private const val TRIAL_PACKAGE_DURATION = 3

class InitializingActivityViewModel : ViewModel() {
    private val myNetworkTimeout = MyNetworkTimeout()

    private val _timeout: MutableLiveData<Boolean> = myNetworkTimeout.timeout
    val timeout: LiveData<Boolean> = _timeout

    private val subjectNames = ArrayList<String>()
    private lateinit var subjectAndFileNameDataListModel: SubjectAndFileNameDataListModel

    private lateinit var gceOLMcqDatabase: GceOLMcqDatabase

    private var userRemoteParseObject = MutableLiveData<ParseObject>()
    private var mobileId: String? = null

    private val mutableExpiresOnList = MutableLiveData<ArrayList<String>?>()
    private val mutableSubjectPackageDataList = MutableLiveData<ArrayList<SubjectPackageData>?>()

    private val _isMcqAppInitialised = MutableLiveData<Boolean?>()
    val isMcqAppInitialised: LiveData<Boolean?> = _isMcqAppInitialised

    private val query: ParseQuery<ParseObject> = ParseQuery.getQuery(BACK4APP_PACKAGE_NAME)

    init {

        mutableSubjectPackageDataList.value = null
        mutableExpiresOnList.value = null
    }


    fun initAppDataBase(gceOLMcqDatabase: GceOLMcqDatabase) {
        this.gceOLMcqDatabase = gceOLMcqDatabase
    }

    fun initSubjectAndFileNameDataList(subjectsDataJsonString: String?) {
        subjectAndFileNameDataListModel =
            Gson().fromJson(subjectsDataJsonString, SubjectAndFileNameDataListModel::class.java)
        if (subjectAndFileNameDataListModel.subjectAndFileNameDataList.isNotEmpty()) {
            initSubjectNames()
        }
    }

    private fun setSubjectPackageDataListFromLocalDatabase() {

        viewModelScope.launch(Dispatchers.IO) {
            val tempSubjectPackageDataList =
                gceOLMcqDatabase.subjectPackageDao().getAllSubjectsPackages()
            withContext(Dispatchers.Main) {
                val packageDataList = ArrayList<SubjectPackageData>()
                val expiryDataList = ArrayList<String>()
                println("tempSubjectPackageDataList: $tempSubjectPackageDataList")
                if (tempSubjectPackageDataList.isNotEmpty()) {
//                    println("setSubjectPackageDataListFromLocalDatabase")
                    tempSubjectPackageDataList.forEach {
                        packageDataList.add(it)
                        expiryDataList.add(it.expiresOn!!)
                    }

                    syncSubjectPackageList(packageDataList, expiryDataList)

                } else {
                    querySubjectsPackagesByMobileIdFromRemoteRepo()

                }
            }
        }

    }

    private fun syncSubjectPackageList(
        packageDataList: ArrayList<SubjectPackageData>,
        expiryDataList: ArrayList<String>
    ) {
        if (subjectNames.size > packageDataList.size) {
            val activationExpiryDates =
                ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                    ActivationExpiryDatesGenerator.HOURS,
                    5
                )
            for (index in packageDataList.size until subjectNames.size) {

                val subjectPackageData = SubjectPackageData(
                    index,
                    subjectNames[index],
                    "TRIAL",
                    activationExpiryDates.activatedOn,
                    activationExpiryDates.expiresOn
                )

                packageDataList.add(subjectPackageData)
                expiryDataList.add(subjectPackageData.expiresOn!!)
//                insertSubjectPackageDataInDatabase(subjectPackageData)
            }
        }
//        setLocalInitData(packageDataList, expiryDataList, true)
        println("packageDataList: $packageDataList")
        println("expiryDataList: $expiryDataList")
        setInitData(packageDataList, expiryDataList, true)


//
    }

    private fun querySubjectsPackagesByMobileIdFromRemoteRepo() {
        println("Query back4app")

//        query.cancel()
        query.whereEqualTo("mobileId", mobileId)
//        query.limit = 1
//        checkForNetworkTimeout()

//         startTimer()
        query.findInBackground { objects, e ->
            val packageDataList = ArrayList<SubjectPackageData>()
            val expiryDataList = ArrayList<String>()
            println("ParseObjects: $objects")
            if (e == null) {

                if (objects.isNotEmpty()) {
                    userRemoteParseObject.value = objects[0]

                    val jsonArraySubjectPackages: JSONArray? =
                        userRemoteParseObject.value!!.getJSONArray("jsonArraySubjectPackages")
                    for (index in 0 until jsonArraySubjectPackages!!.length()) {

                        val jsonObject = jsonArraySubjectPackages.getJSONObject(index)

                        val subjectPackageData = SubjectPackageData(
                            packageIndex = jsonObject.getInt(PACKAGE_INDEX),
                            subjectName = jsonObject.getString(SUBJECT_NAME),
                            packageName = jsonObject.getString(PACKAGE_NAME),
                            activatedOn = jsonObject.getString(ACTIVATED_ON),
                            expiresOn = jsonObject.getString(EXPIRES_ON)
                        )
                        packageDataList.add(subjectPackageData)
                        expiryDataList.add(subjectPackageData.expiresOn!!)

                    }
                    println("querying back4App $packageDataList")
                    syncSubjectPackageList(packageDataList, expiryDataList)
//                    setLocalInitData(packageDataList, expiryDataList, true)
//                    saveCurrentPackageToLocalDB(packageDataList)
//

                } else {
                    println("back4App data list is empty")
                    activateTrialAccounts()
//

                }

            } else {
                println("exception.... ${e.localizedMessage}")
                setInitData(null, null, false)


            }
        }
    }

    private fun setInitData(
        packageDataList: ArrayList<SubjectPackageData>?,
        expiresOnList: ArrayList<String>?,
        isMcqAppInitialised: Boolean?
    ) {
        mutableSubjectPackageDataList.value = packageDataList
        mutableExpiresOnList.value = expiresOnList

//        saveCurrentPackageToBack4App(packageDataList)
        saveCurrentPackageToLocalDB(packageDataList)
        this._isMcqAppInitialised.value = isMcqAppInitialised


    }

    private fun initSubjectNames() {
        subjectAndFileNameDataListModel.subjectAndFileNameDataList.forEach {
            subjectNames.add(it.subject)
        }

        println("subject names: $subjectNames")
        if (subjectNames.isNotEmpty()) {
            setSubjectPackageDataListFromLocalDatabase()
        }
    }

    fun getSubjectFileNameList(): ArrayList<String> {
        val subjectFileNames = ArrayList<String>()
        subjectAndFileNameDataListModel.subjectAndFileNameDataList.forEach {
            subjectFileNames.add(it.fileName)
        }
        return subjectFileNames
    }

    fun getSubjectExpiryList(): ArrayList<String> {
        return mutableExpiresOnList.value!!
    }


    fun getSubjectPackageDataList(): SubjectPackageDataList {
        return SubjectPackageDataList(mutableSubjectPackageDataList.value!!)
    }

    private fun activateTrialAccounts() {
        val activationExpiryDates =
            ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                ActivationExpiryDatesGenerator.HOURS,
                TRIAL_PACKAGE_DURATION
            )
        val packageDataList = ArrayList<SubjectPackageData>()
        val expiryDataList = ArrayList<String>()
        subjectNames.forEachIndexed { index, subject ->

            packageDataList.add(
                SubjectPackageData(
                    index,
                    subject,
                    "TRIAL",
                    activationExpiryDates.activatedOn,
                    activationExpiryDates.expiresOn
                )
            )
            expiryDataList.add(activationExpiryDates.expiresOn)

        }
        saveCurrentPackageToBack4App(packageDataList)
        setInitData(packageDataList, expiryDataList, true)


//        println("Trial accounts activated ${mutableSubjectPackageDataList.value}")

    }

    fun getSubjectNames(): ArrayList<String> {
        return subjectNames
    }


    fun setMobileId(ID: String) {
        mobileId = ID
        println("device id: $ID")
    }

    private fun saveCurrentPackageToLocalDB(subjectPackageDataList: List<SubjectPackageData>?) {
        subjectPackageDataList?.let {
            viewModelScope.launch(Dispatchers.IO) {
                gceOLMcqDatabase.subjectPackageDao().deleteAll()
                mutableSubjectPackageDataList.value!!.forEach {
                    gceOLMcqDatabase.subjectPackageDao().insert(it)
                }
                println("saving to local database complete")

            }
        }
    }

    private fun saveCurrentPackageToBack4App(subjectPackageDataList: List<SubjectPackageData>?) {

        subjectPackageDataList?.let {
            if(userRemoteParseObject.value == null){
                println("Object is null....")
                userRemoteParseObject.value = ParseObject(BACK4APP_PACKAGE_NAME)
            }
            val jsonArray = JSONArray()
            subjectPackageDataList.forEachIndexed { _, subjectPackageData ->
                val jsonObject = JSONObject()
                jsonObject.apply {
                    put(PACKAGE_INDEX, subjectPackageData.packageIndex)
                    put(SUBJECT_NAME, subjectPackageData.subjectName)
                    put(PACKAGE_NAME, subjectPackageData.packageName)
                    put(ACTIVATED_ON, subjectPackageData.activatedOn)
                    put(EXPIRES_ON, subjectPackageData.expiresOn)
                }
                jsonArray.put(jsonObject)

            }

            userRemoteParseObject.value?.put(MOBILE_ID, mobileId!!)
            userRemoteParseObject.value?.put(JSON_ARRAY_SUBJECT_PACKAGES, jsonArray)
//        back4AppParseObject.saveEventually()
            userRemoteParseObject.value?.saveInBackground {
                println("Saving......")
                if (it == null) {
//                isMcqAppInitialised.value = true
                    println("Saving to Back4App database successful......")
                } else {
//                    back4AppParseObjectId.value = null
                }
            }
//



        }
    }

    fun cancelNetworkQuery() {
        query.cancel()
        myNetworkTimeout.cancelTimer()
    }

    fun setIsAppInitialisedFalse() {
//        query.cancel()
        _isMcqAppInitialised.value = false
    }

    private fun checkForNetworkTimeout() {
        myNetworkTimeout.startTimer(15000L, 1000L)

    }


}