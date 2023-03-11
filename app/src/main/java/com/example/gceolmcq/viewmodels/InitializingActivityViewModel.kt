package com.example.gceolmcq.viewmodels


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.datamodels.SubjectAndFileNameDataList
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

class InitializingActivityViewModel : ViewModel() {

    private val subjectNames = ArrayList<String>()
    private lateinit var subjectAndFileNameDataList: SubjectAndFileNameDataList

    private lateinit var gceOLMcqDatabase: GceOLMcqDatabase

    private var back4AppParseObjectId = MutableLiveData<String?>()
    private var mobileId: String? = null

    private val mutableExpiresOnList = MutableLiveData<ArrayList<String>?>()
    private val mutableSubjectPackageDataList = MutableLiveData<ArrayList<SubjectPackageData>?>()

    private val isMcqAppInitialised = MutableLiveData<Boolean?>()
    private val query: ParseQuery<ParseObject> = ParseQuery(BACK4APP_PACKAGE_NAME)
    private var back4AppParseObject: ParseObject? = null

    init {

        mutableSubjectPackageDataList.value = null
        mutableExpiresOnList.value = null
    }


    fun initAppDataBase(gceOLMcqDatabase: GceOLMcqDatabase) {
        this.gceOLMcqDatabase = gceOLMcqDatabase
    }

    fun initialiseApp(subjectsDataJsonString: String?): LiveData<Boolean?> {
        initSubjectAndFileNameDataList(subjectsDataJsonString)
        return isMcqAppInitialised
    }

    private fun initSubjectAndFileNameDataList(subjectsDataJsonString: String?) {
        subjectAndFileNameDataList =
            Gson().fromJson(subjectsDataJsonString, SubjectAndFileNameDataList::class.java)
        initSubjectNames()
        setSubjectPackageDataListFromLocalDatabase()
    }

    private fun setSubjectPackageDataListFromLocalDatabase() {


        viewModelScope.launch(Dispatchers.IO) {
            val tempSubjectPackageDataList =
                gceOLMcqDatabase.subjectPackageDao().getAllSubjectsPackages()
            withContext(Dispatchers.Main) {
                val packageDataList = ArrayList<SubjectPackageData>()
                val expiryDataList = ArrayList<String>()
                if (tempSubjectPackageDataList.isNotEmpty()) {
//                    println("setSubjectPackageDataListFromLocalDatabase")
                    tempSubjectPackageDataList.forEach {
                        packageDataList.add(it)
                        expiryDataList.add(it.expiresOn!!)
                    }

//                    println("Package database is not empty")
                    syncSubjectPackageList(packageDataList, expiryDataList)
                    setLocalInitData(packageDataList, expiryDataList, true)
                    return@withContext

                } else {
                    queryBack4AppSubjectPackageByMobileId()

                }
            }
        }


//
    }

    private fun syncSubjectPackageList(
        packageDataList: ArrayList<SubjectPackageData>,
        expiryDataList: ArrayList<String>
    ) {
        if (subjectNames.size > packageDataList.size) {
            val activationExpiryDates =
                ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                    ActivationExpiryDatesGenerator.MINUTES,
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
                insertSubjectPackageDataInDatabase(subjectPackageData)
            }
        }
//
    }

    private fun queryBack4AppSubjectPackageByMobileId() {
//        val query: ParseQuery<ParseObject> = ParseQuery(BACK4APP_PACKAGE_NAME)
        query.cancel()
        query.whereContains("mobileId", mobileId)
        println()
        query.limit = 1
        query.findInBackground { objects, e ->

            val packageDataList = ArrayList<SubjectPackageData>()
            val expiryDataList = ArrayList<String>()

            if (e == null) {
                println("ParseObjects: $objects")
                if (objects.isNotEmpty()) {
//                    back4AppParseObjectId.value = objects[0].objectId

                    back4AppParseObject = objects[0]

//
//                    val packageDataList = ArrayList<SubjectPackageData>()
                    val jsonArraySubjectPackages: JSONArray? =
                        back4AppParseObject!!.getJSONArray("jsonArraySubjectPackages")
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
                    setLocalInitData(packageDataList, expiryDataList, true)
                    saveCurrentPackageToLocalDB(packageDataList)

                    return@findInBackground
//

                } else {
                    println("back4App data list is empty")
                    activateTrialAccounts()
//                    saveCurrentPackageToBack4App()

                }

            } else {
//                mutableBck4AppSubjectPackageDataList.value = null
                println("exception.... ${e.localizedMessage}")
                setInitData(null, null, false)


            }
        }
    }

    private fun setLocalInitData(
        packageDataList: ArrayList<SubjectPackageData>?,
        expiresOnList: ArrayList<String>?,
        isMcqAppInitialised: Boolean?
    ) {
        mutableSubjectPackageDataList.value = packageDataList
        mutableExpiresOnList.value = expiresOnList
        this.isMcqAppInitialised.value = isMcqAppInitialised
    }

    private fun setInitData(
        packageDataList: ArrayList<SubjectPackageData>?,
        expiresOnList: ArrayList<String>?,
        isMcqAppInitialised: Boolean?
    ) {
        mutableSubjectPackageDataList.value = packageDataList
        mutableExpiresOnList.value = expiresOnList
        this.isMcqAppInitialised.value = isMcqAppInitialised
        saveCurrentPackageToBack4App(packageDataList)
        saveCurrentPackageToLocalDB(packageDataList)


    }

    private fun initSubjectNames() {
        subjectAndFileNameDataList.subjectAndFileNameDataArrayList.forEach {
            subjectNames.add(it.subject)
        }
    }

    fun getSubjectFileNameList(): ArrayList<String> {
        val subjectFileNames = ArrayList<String>()
        subjectAndFileNameDataList.subjectAndFileNameDataArrayList.forEach {
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
                ActivationExpiryDatesGenerator.MINUTES,
                5
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

        setInitData(packageDataList, expiryDataList, true)

//        println("Trial accounts activated ${mutableSubjectPackageDataList.value}")

    }

    fun getSubjectNames(): ArrayList<String> {
        return subjectNames
    }


    fun setMobileId(ID: String) {
        mobileId = ID
    }


    fun nullifyIsAppInitialised() {
        isMcqAppInitialised.value = null
    }

    private fun saveCurrentPackageToLocalDB(subjectPackageDataList: List<SubjectPackageData>?) {
        subjectPackageDataList?.let {
            viewModelScope.launch(Dispatchers.IO) {
                mutableSubjectPackageDataList.value!!.forEach {
                    gceOLMcqDatabase.subjectPackageDao().insert(it)
                }
                println("saving to local database complete")

            }
        }
    }

    private fun saveCurrentPackageToBack4App(subjectPackageDataList: List<SubjectPackageData>?) {
        subjectPackageDataList?.let {
            val back4AppParseObject = ParseObject(BACK4APP_PACKAGE_NAME)

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

            back4AppParseObject.put(MOBILE_ID, mobileId!!)
            back4AppParseObject.put(JSON_ARRAY_SUBJECT_PACKAGES, jsonArray)
//        back4AppParseObject.saveEventually()
            back4AppParseObject.saveInBackground {
                println("Saving......")
                if (it == null) {
//                isMcqAppInitialised.value = true
                    println("Saving to Back4App database successful......")
                } else {
                    back4AppParseObjectId.value = null
                }
            }

        }
    }

    private fun insertSubjectPackageDataInDatabase(subjectPackageData: SubjectPackageData) {
        viewModelScope.launch(Dispatchers.IO) {
            gceOLMcqDatabase.subjectPackageDao().insert(subjectPackageData)


        }
    }


}