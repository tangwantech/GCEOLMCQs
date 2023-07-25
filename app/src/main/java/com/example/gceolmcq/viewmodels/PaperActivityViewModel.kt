package com.example.gceolmcq.viewmodels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.datamodels.*
//import com.example.gceolmcq.datamodels.SectionAnsweredScoreData
import com.google.gson.Gson

class PaperActivityViewModel:ViewModel() {

    private var examItemDataModel: ExamItemDataModel? = null
    private var paperDataModel: PaperDataModel? = null
    private lateinit var subjectName: String
    private var currentFragmentIndex: Int? = null
    private var currentSectionIndex = 0

    private var isSectionsAnsweredData: ArrayList<Boolean> = ArrayList()
    private val paperScore = MutableLiveData<Int?>()

    private val sectionScores = MutableLiveData<ArrayList<Int>>()

    private var sectionsAnsweredCount = 0

    private var currentSectionRetryCount = MutableLiveData<Int>()

    private val unAnsweredSectionIndexes: ArrayList<Int> = ArrayList()

    private lateinit var userMarkedAnswersSheetData: UserMarkedAnswersSheetData
    private lateinit var sectionResultData: SectionResultData

    private val _subjectPackage = MutableLiveData<SubjectPackageData>()

    init {
        sectionScores.value = ArrayList()
        paperScore.value = 0
        currentSectionRetryCount.value = MCQConstants.SECTION_RETRY_LIMIT
    }

    fun setExamItemData(examItemDataModel: ExamItemDataModel){
        this.examItemDataModel = examItemDataModel
    }

    fun getExamFileName(): String{
        return examItemDataModel!!.fileName
    }

    fun getExamTitle(): String{
        return examItemDataModel!!.title
    }
    fun initPaperData(paperDataJsonString: String?){
        if(paperDataJsonString != null){
            paperDataModel = Gson().fromJson(paperDataJsonString, PaperDataModel::class.java)
            initIsSectionsAnswered()
            initSectionScores()
        }

    }

    private fun initSectionScores(){
        for(sectionIndex in 0..paperDataModel!!.numberOfSections){
            sectionScores.value!!.add(0)
        }
    }

    fun getUnAnsweredSectionIndexes(): List<Int>{
        return unAnsweredSectionIndexes
    }

    fun setCurrentSectionIndex(sectionIndex: Int){
        currentSectionIndex = sectionIndex
    }

    fun getCurrentSectionIndex(): Int = currentSectionIndex

    fun setCurrentFragmentIndex(index: Int){
        currentFragmentIndex = index
    }

    fun getCurrentFragmentIndex():Int?{
        return currentFragmentIndex
    }

    fun resetCurrentFragmentIndex(){
        currentFragmentIndex = null
    }

    fun getTotalNumberOfQuestions():Int{
        return paperDataModel!!.numberOfQuestions
    }

    fun getSectionNames(): Array<String>?{
        var sectionNames: Array<String>? = null
        paperDataModel?.let {
            sectionNames = Array(it.sections.size){""}
            it.sections.forEachIndexed { index, sectionDataModel ->
                sectionNames!![index] = sectionDataModel.title

            }
        }

        return sectionNames

    }
    fun getSectionNameBundleList(): Array<Bundle>?{
        var sectionNameBundleList: Array<Bundle>? = null
        paperDataModel?.let {
            sectionNameBundleList = Array(it.sections.size){Bundle()}
            it.sections.forEachIndexed { index, sectionDataModel ->
                sectionNameBundleList!![index].apply {
                    putString("sectionName", sectionDataModel.title)
                    putString("numberOfQuestions", sectionDataModel.numberOfQuestions.toString())
                }

            }
        }

        return sectionNameBundleList

    }

    private fun initIsSectionsAnswered(){
        for(sectionIndex in 0..paperDataModel!!.numberOfSections){
            isSectionsAnsweredData.add(false)
        }

    }

    fun getSectionData(position: Int):SectionDataModel{
        return paperDataModel!!.sections[position]
    }

    fun getNumberOfSections(): Int{
        return paperDataModel!!.numberOfSections
    }

    fun updateSectionsScore(sectionIndex: Int, score: Int){
        updateIsSectionsAnswered(sectionIndex)
        sectionScores.value!![sectionIndex] = score
        updatePaperScore(sectionScores.value!!)

    }

    fun getSectionScores(): ArrayList<Int>{
        return sectionScores.value!!
    }

    fun resetSectionScore(sectionIndex: Int){
        updateSectionsScore(sectionIndex, 0)
    }


    private fun updatePaperScore(sectionScores: List<Int>){
        paperScore.value = sectionScores.sum()

    }

    fun getPaperScore(): Int{

        return paperScore.value!!
    }

    fun updateIsSectionsAnswered(sectionIndex: Int){
        isSectionsAnsweredData[sectionIndex] = true
        updateSectionsAnsweredCount()
    }

    private fun updateSectionsAnsweredCount(){
        for(isAnswered in isSectionsAnsweredData){
            if(isAnswered){
                sectionsAnsweredCount += 1
            }
        }

    }

    fun getIsSectionsAnswered(): List<Boolean>{
        return isSectionsAnsweredData
    }

    fun updateSubjectPackageData(subjectPackageData: SubjectPackageData){
        _subjectPackage.value = subjectPackageData
    }

    fun getSectionNumberAt(position: Int): String {
        return getSectionNames()!![position]
    }

    fun getIsSectionAnsweredAt(position: Int): Boolean {
        return isSectionsAnsweredData[position]
    }

    fun decrementCurrentSectionRetryCount(){
        currentSectionRetryCount.value = currentSectionRetryCount.value?.minus(1)

    }

    fun resetCurrentSectionRetryCount(){
        currentSectionRetryCount.value = MCQConstants.SECTION_RETRY_LIMIT
    }

    fun getCurrentSectionRetryCount(): LiveData<Int>{
        return currentSectionRetryCount
    }

    fun setUserMarkedAnswerSheet(userMarkedAnswersSheetData: UserMarkedAnswersSheetData){
        this.userMarkedAnswersSheetData = userMarkedAnswersSheetData
    }

    fun getUserMarkedAnswerSheet(): UserMarkedAnswersSheetData = userMarkedAnswersSheetData

    fun setSectionResultData(sectionResultData: SectionResultData){
        this.sectionResultData = sectionResultData
    }

    fun getSectionResultData(): SectionResultData = sectionResultData

    fun setSubjectName(subjectName: String) {
        this.subjectName = subjectName
    }
//
//    fun getSubjectName(): String{
//        return subjectName
//    }

}