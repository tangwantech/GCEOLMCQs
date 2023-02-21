package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.datamodels.*
//import com.example.gceolmcq.datamodels.SectionAnsweredScoreData
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlin.math.roundToInt

private const val RETRY_COUNT = 2
class PaperActivityViewModel:ViewModel() {

    private var mcqDatabase: GceOLMcqDatabase? = null
    private var examItemDataModel: ExamItemDataModel? = null
    private var paperDataModel: PaperDataModel? = null
    private var currentViewIndex: Int? = null

    private var isSectionsAnsweredData: ArrayList<Boolean> = ArrayList()
    private val paperScore = MutableLiveData<Int?>()

    private val sectionScores = MutableLiveData<ArrayList<Int>>()

    private var statisticsData1: StatisticsData? = null
    private var sectionsAnsweredCount = 0
    private var isPaperAttempted:Boolean = false

    private var currentSectionRetryCount = MutableLiveData<Int>()

    private val unAnsweredSectionIndexes: ArrayList<Int> = ArrayList()


    init {
        sectionScores.value = ArrayList()
        paperScore.value = 0
        currentSectionRetryCount.value = RETRY_COUNT
    }

    private fun initStatisticsData(customId: String){

        if(this.statisticsData1 == null){
            statisticsData1 = StatisticsData(
                id=null,
                customId = customId,
                numberOfQuestions = paperDataModel!!.numberOfQuestions,
                attemptsCount = 0,
                scores = null

            )

        }

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


    fun setCurrentViewIndex(index: Int){
        currentViewIndex = index
    }

    fun getCurrentViewIndex():Int?{
        return currentViewIndex
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
        setIsPaperAttempted()
        updatePaperScore(sectionScores.value!!)

    }

    private fun setIsPaperAttempted(){
        if(!isPaperAttempted){
            isPaperAttempted = true
            updateStatisticsDataAttemptsCount()
        }

    }

    fun getIsPaperAttempted(): Boolean{
        return isPaperAttempted
    }

    fun resetSectionScore(sectionIndex: Int){
        updateSectionsScore(sectionIndex, 0)
    }


    private fun updatePaperScore(sectionScores: List<Int>){
        paperScore.value = sectionScores.sum()

    }

    fun setStatisticsDataScores(){
        val score = Score(paperScore.value!!)
        val scores = ArrayList<Score>()
        scores.add(score)
        statisticsData1?.scores = scores
    }

    fun updateStatisticsDataScores(){
        val score = Score(paperScore.value!!)
        val scores = ArrayList<Score>()
        statisticsData1!!.scores!!.forEachIndexed { _, tempScore ->
            scores.add(tempScore)
        }
        scores.add(score)
        statisticsData1?.scores = scores

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

    fun setDataBase(mcqDatabase: GceOLMcqDatabase){
        this.mcqDatabase = mcqDatabase
    }

    fun queryStatisticsDataTableByCustomId(customId: String){
        var tempStatisticsData: StatisticsData?
        CoroutineScope(Dispatchers.IO).launch {

//            mcqDatabase?.statisticsDataDao()?.deleteAll()
            tempStatisticsData = mcqDatabase?.statisticsDataDao()?.findByCustomId(customId)
            withContext(Dispatchers.IO){
               statisticsData1 = tempStatisticsData
                println("PaperScores: $statisticsData1")
                initStatisticsData(customId)
            }
//

        }

    }


    fun updateStatisticsDataTable(){
        if(statisticsData1?.attemptsCount!! != 0){
            CoroutineScope(Dispatchers.IO).launch {
                mcqDatabase?.statisticsDataDao()?.update(statisticsData1!!)
            }
        }
    }

    fun insertToStatisticsDataTable(){
        CoroutineScope(Dispatchers.IO).launch {
            mcqDatabase?.statisticsDataDao()?.insert(statisticsData1!!)
        }

    }

    private fun updateStatisticsDataAttemptsCount(){
        statisticsData1?.attemptsCount = statisticsData1?.attemptsCount!! + 1
    }



    fun getAttemptCount(): Int {
        return this.statisticsData1?.attemptsCount!!

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
        currentSectionRetryCount.value = RETRY_COUNT
    }

    fun getCurrentSectionRetryCount(): LiveData<Int>{
        return currentSectionRetryCount
    }

}