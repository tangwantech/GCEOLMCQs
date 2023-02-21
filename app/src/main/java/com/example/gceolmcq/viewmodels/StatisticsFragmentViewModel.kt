package com.example.gceolmcq.viewmodels

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.datamodels.SubjectAndFileNameData


private const val SUBJECT_NAMES = "subjectNames"
private const val SUBJECT_FILENAME_LIST = "subjectAndFileNameList"
class StatisticsFragmentViewModel: ViewModel() {

    private lateinit var subjectNames: ArrayList<String>
    private lateinit var subjectFileNameDataList: ArrayList<String>
    private lateinit var initDataBundle: Bundle
    private var currentViewIndex: Int? = null

    fun setInitDataBundle(bundle: Bundle){
        initDataBundle = bundle
        initDataBundle.apply {
            setSubjectNames(getStringArrayList(SUBJECT_NAMES)!!)
            setSubjectFileNameDataList(getStringArrayList(SUBJECT_FILENAME_LIST)!!)
        }

    }

    private fun setSubjectNames(subjectNames: ArrayList<String>) {
        this.subjectNames = subjectNames
    }

    fun getSubjectNames(): ArrayList<String>{
        return subjectNames
    }

    private fun setSubjectFileNameDataList(subjectFileNameDataList: ArrayList<String>){
        this.subjectFileNameDataList = subjectFileNameDataList
    }

    fun getSubjectFileNames(): ArrayList<String> {

        return this.subjectFileNameDataList
    }

    fun setCurrentViewIndex(index: Int){
        currentViewIndex = index
    }

    fun getCurrentViewIndex():Int?{
        return currentViewIndex
    }

    fun getSubjectAndFileNameDataAt(position: Int): SubjectAndFileNameData {
        return SubjectAndFileNameData(subjectNames[position], subjectFileNameDataList[position])
    }

}