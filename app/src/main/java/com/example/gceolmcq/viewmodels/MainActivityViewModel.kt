package com.example.gceolmcq.viewmodels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.datamodels.SubjectAndFileNameData
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.datamodels.SubjectPackageDataList
import com.example.gceolmcq.datamodels.SubjectPackageExpiryStatusData
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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

class MainActivityViewModel : ViewModel() {

    private lateinit var subjectNames: ArrayList<String>
    private lateinit var subjectFileNameDataList: ArrayList<String>

    private var mobileId: String? = null

    private val subjectPackageExpiryStatusDataListLiveData =
        MutableLiveData<ArrayList<SubjectPackageExpiryStatusData>>()

    private val subjectPackageExpiryBundle = MutableLiveData<Bundle>()

    private lateinit var subjectPackageDB: GceOLMcqDatabase

    private val mutableSubjectPackageDataList = MutableLiveData<ArrayList<SubjectPackageData>?>()

    private val isActivatedPackageUpdatedInLocalDatabase = MutableLiveData<Boolean>()

    private val activatedPackageIndex = MutableLiveData<Int>()

    init {
        mutableSubjectPackageDataList.value = null
        isActivatedPackageUpdatedInLocalDatabase.value = false
    }

    fun setMobileId(mobileID: String) {
        this.mobileId = mobileID
    }

    fun setSubjectNameList(subjectNames: ArrayList<String>) {
        this.subjectNames = subjectNames
    }

    fun getActivatedPackageIndex(): LiveData<Int>{
        return activatedPackageIndex
    }

    fun initSubjectDataBase(gceOLMcqDatabase: GceOLMcqDatabase) {
        this.subjectPackageDB = gceOLMcqDatabase
    }

    private fun setSubjectPackageExpiryStatusDataList(subjectPackageDataList: List<SubjectPackageData>) {
        val subjectPackageExpiryStatusDataList = ArrayList<SubjectPackageExpiryStatusData>()
        subjectPackageDataList.forEachIndexed { _, subjectPackageData ->
            val subjectPackageExpiryStatusData =
                SubjectPackageExpiryStatusData(
                    subjectPackageData.subjectName!!,
                    subjectPackageData.packageName!!,
                    subjectPackageData.expiresOn!!,
                    ActivationExpiryDatesGenerator().checkExpiry(subjectPackageData.expiresOn!!)
                )
            subjectPackageExpiryStatusDataList.add(subjectPackageExpiryStatusData)
        }
        this.subjectPackageExpiryStatusDataListLiveData.value = subjectPackageExpiryStatusDataList
    }

    fun getSubjectPackageExpiryStatusDataList(): ArrayList<SubjectPackageExpiryStatusData> {
        return this.subjectPackageExpiryStatusDataListLiveData.value!!
    }

    fun getSubjectPackageExpiryStatusDataListLiveData(): LiveData<ArrayList<SubjectPackageExpiryStatusData>> {
        return this.subjectPackageExpiryStatusDataListLiveData
    }

    fun setSubjectFileNameList(subjectFileNameList: ArrayList<String>) {
        this.subjectFileNameDataList = subjectFileNameList
    }

    fun getSubjectAndFileNameDataAt(position: Int): SubjectAndFileNameData {
        return SubjectAndFileNameData(subjectNames[position], subjectFileNameDataList[position])
    }

    fun activatePackage(subjectIndex: Int, packageType: String, packageDuration: Int) {
        val activationExpiryDates =
            ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                ActivationExpiryDatesGenerator.MINUTES,
                packageDuration
            )
        mutableSubjectPackageDataList.value!![subjectIndex].apply {
            packageIndex = subjectIndex
            packageName = packageType
            activatedOn = activationExpiryDates.activatedOn
            expiresOn = activationExpiryDates.expiresOn
        }

        updateBack4AppByMobileId(mutableSubjectPackageDataList.value!!)
        updateActivatedSubjectPackageDataInLocalDatabase(
            subjectIndex,
            mutableSubjectPackageDataList.value!![subjectIndex]
        )
    }


    fun getSubjectExpiryDataAt(position: Int): String {
        return mutableSubjectPackageDataList.value!![position].expiresOn!!
    }

    fun getSubjectPackageDataAt(position: Int): SubjectPackageData {
        return mutableSubjectPackageDataList.value!![position]

    }

    fun getSubjectNameAt(position: Int): String {
        return subjectNames[position]
    }

    private fun updateActivatedSubjectPackageDataInLocalDatabase(
        position: Int,
        subjectPackageData: SubjectPackageData
    ) {
        viewModelScope.launch(Dispatchers.IO) {

            val id = subjectPackageDB.subjectPackageDao().update(subjectPackageData)
            withContext(Dispatchers.Main) {

                println("package at Id:$id was updated successfully")
                getActivatedSubjectPackageDataFromLocalDatabase(id, position)
            }
        }
    }

    private fun getActivatedSubjectPackageDataFromLocalDatabase(id: Int, position: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val subjectPackageData =
                subjectPackageDB.subjectPackageDao().findBySubjectName(subjectNames[position])
//            delay(3000)
            withContext(Dispatchers.Main) {
                mutableSubjectPackageDataList.value!![position] = subjectPackageData
                isActivatedPackageUpdatedInLocalDatabase.value = true
                activatedPackageIndex.value = position

            }
        }

    }

    fun getActivatedPackageName(position: Int): String?{
        return mutableSubjectPackageDataList.value!![position].packageName
    }

    private fun updateBack4AppByMobileId(subjectPackageDataList: List<SubjectPackageData>?) {
        subjectPackageDataList?.let {
            val query: ParseQuery<ParseObject> = ParseQuery(BACK4APP_PACKAGE_NAME)
            query.whereContains("mobileId", mobileId)
            query.limit = 1
            query.findInBackground { objects, e ->
                if (e == null) {
                    val parseObject = objects[0]
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
                    parseObject.put(MOBILE_ID, mobileId!!)
                    parseObject.put(JSON_ARRAY_SUBJECT_PACKAGES, jsonArray)
                    parseObject.saveInBackground {
                        if (it == null) {
                            println("Updated successfully")
//                                return@saveInBackground
                        } else {
                            println("Update failed")
                        }
                    }
                }
            }
        }

    }

    fun updateSubjectExpiryBundle(subjectIndex: Int) {
        val bundle = Bundle()
        bundle.putString("subject", subjectNames[subjectIndex])
        bundle.putInt("position", subjectIndex)
        bundle.putString("package", mutableSubjectPackageDataList.value!![subjectIndex].packageName)
        bundle.putString("expiresOn", mutableSubjectPackageDataList.value!![subjectIndex].expiresOn)
        val expiresOnTemp = mutableSubjectPackageDataList.value!![subjectIndex].expiresOn!!
        bundle.putBoolean("status", ActivationExpiryDatesGenerator().checkExpiry(expiresOnTemp))

        subjectPackageExpiryBundle.value = bundle

    }

    fun getSubjectExpiresOnBundle(): LiveData<Bundle> {
        return subjectPackageExpiryBundle
    }

    fun initializeSubjectPackageDataFromLocalDb() {
        viewModelScope.launch(Dispatchers.IO) {
            val tempSubjectPackageDataList =
                subjectPackageDB.subjectPackageDao().getAllSubjectsPackages()
            withContext(Dispatchers.Main) {
                val packageDataList = ArrayList<SubjectPackageData>()
                val expiryDataList = ArrayList<String>()
                tempSubjectPackageDataList.forEach {
                    packageDataList.add(it)
                    expiryDataList.add(it.expiresOn!!)
                }

//                println("Reading from db within main activity: $packageDataList")
                setPackageDataList(packageDataList)
                setSubjectPackageExpiryStatusDataList(packageDataList)

            }
        }
    }

    private fun setPackageDataList(packageDataList: ArrayList<SubjectPackageData>) {
        this.mutableSubjectPackageDataList.value = packageDataList
    }

    fun getPackageNameAt(position: Int): String {
        return subjectPackageExpiryStatusDataListLiveData.value!![position].packageName
    }

}

