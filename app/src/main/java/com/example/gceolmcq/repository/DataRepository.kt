package com.example.gceolmcq.repository

import android.content.Context
import com.example.gceolmcq.datamodels.SubjectPackageData
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.parse.ParseObject
import com.parse.ParseQuery
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

class DataRepository(private val context: Context) {
    private lateinit var gceOLMcqDatabase: GceOLMcqDatabase
    private val query: ParseQuery<ParseObject> = ParseQuery(BACK4APP_PACKAGE_NAME)

    private fun updateBack4AppByMobileId(subjectPackageDataList: List<SubjectPackageData>?, mobileId: String) {
        subjectPackageDataList?.let {
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
                    parseObject.put(MOBILE_ID, mobileId)
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

    private fun updateActivatedSubjectPackageDataInLocalDatabase(
        subjectPackageData: SubjectPackageData
    ) {
        gceOLMcqDatabase.subjectPackageDao().update(subjectPackageData)

    }

    private fun getActivatedSubjectPackageDataFromLocalDatabase(subjectName: String): SubjectPackageData {
        return gceOLMcqDatabase.subjectPackageDao().findBySubjectName(subjectName)

    }
}