package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.datamodels.*
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubjectContentTableViewModel: ViewModel() {
    private lateinit var subjectData: SubjectData
    private val examTitles: ArrayList<String?> = ArrayList()
    private val examContents: HashMap<Int, ArrayList<String>?> = HashMap()
    private val examContentsFileNames: HashMap<String, String> = HashMap()
    private val isSubjectPackageActive = MutableLiveData<Boolean>()
    private var packageName: String? = null

    fun initSubjectContentsData(jsonFile: String){
        subjectData = Gson().fromJson(jsonFile, SubjectData::class.java)

        setExamTitles()
    }

    private fun setExamTitles(){
        subjectData.contents!!.forEachIndexed { index, examTypeData ->
            examTitles.add(examTypeData.title)
            setExamContents(examTypeData, index)
        }


    }
    fun getExamTypeDataAt(position: Int): ExamTypeDataModel{
        return (subjectData.contents!![position])
    }

    fun setPackageName(packageName: String){
        this.packageName = packageName
    }

    fun getPackageName(): String{
        return packageName!!
    }

    fun getExamTitles(): ArrayList<String?>{
        return examTitles
    }

    fun getExamTypesCount():Int{
        return(subjectData.contents!!.size)
    }

    private fun setExamContents(examTypeDataModel: ExamTypeDataModel, index: Int) {
        val examContents: ArrayList<String> = ArrayList()

        examTypeDataModel.examItems.forEach {
            examContents.add(it.title)
            setExamContentsFileNames(it)
        }
        this.examContents[index] = examContents

    }
    private fun setExamContentsFileNames(examItemDataModel: ExamItemDataModel){
        examContentsFileNames[examItemDataModel.title] = examItemDataModel.fileName
    }

    fun checkPackageExpiry(expiryDate: String){
        isSubjectPackageActive.value = ActivationExpiryDatesGenerator().checkExpiry(expiryDate)
    }

    fun getIsPackageActive(): LiveData<Boolean>{
        return isSubjectPackageActive
    }

}