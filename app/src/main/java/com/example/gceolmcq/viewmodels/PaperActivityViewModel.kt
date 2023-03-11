package com.example.gceolmcq.viewmodels

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.MomoPayService
import com.example.gceolmcq.datamodels.*
//import com.example.gceolmcq.datamodels.SectionAnsweredScoreData
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.google.gson.Gson
import kotlinx.coroutines.*

private const val RETRY_COUNT = 2
class PaperActivityViewModel:ViewModel() {

    private val momoPayService = MomoPayService()

    private var mcqDatabase: GceOLMcqDatabase? = null
    private var examItemDataModel: ExamItemDataModel? = null
    private var paperDataModel: PaperDataModel? = null
    private lateinit var subjectName: String
    private var currentFragmentIndex: Int? = null
    private var currentSectionIndex = 0

    private var isSectionsAnsweredData: ArrayList<Boolean> = ArrayList()
    private val paperScore = MutableLiveData<Int?>()

    private val sectionScores = MutableLiveData<ArrayList<Int>>()

    private var statisticsData1: StatisticsData? = null
    private var sectionsAnsweredCount = 0
    private var isPaperAttempted:Boolean = false

    private var currentSectionRetryCount = MutableLiveData<Int>()

    private val unAnsweredSectionIndexes: ArrayList<Int> = ArrayList()

    private lateinit var userMarkedAnswersSheetData: UserMarkedAnswersSheetData
    private lateinit var sectionResultData: SectionResultData

    private val _subjectPackage = MutableLiveData<SubjectPackageData>()

    private val subscriptionFormData = SubscriptionFormDataModel()
    private val _isSubscriptionFormFilled = MutableLiveData<Boolean>()
    val isSubscriptionFormFilled: LiveData<Boolean> = _isSubscriptionFormFilled

    private val _isPackageActivated = MutableLiveData<Boolean>()
    val isPackageActivated: LiveData<Boolean> = _isPackageActivated


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

    fun querySubjectPackageDataTableBySubjectName(){
        CoroutineScope(Dispatchers.IO).launch{
            val tempSubjectPackageData = mcqDatabase?.subjectPackageDao()?.findBySubjectName(subjectName)!!
            _subjectPackage.postValue(tempSubjectPackageData)
        }

    }

    fun checkSubjectPackageExpiry(): Boolean{
//        _packageHasExpired.value = ActivationExpiryDatesGenerator().checkExpiry(_subjectPackage.value?.expiresOn!!)
        return ActivationExpiryDatesGenerator().checkExpiry(_subjectPackage.value?.expiresOn!!)
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

    fun setUserMarkedAnswerSheet(userMarkedAnswersSheetData: UserMarkedAnswersSheetData){
        this.userMarkedAnswersSheetData = userMarkedAnswersSheetData
    }

    fun getUserMarkedAnswerSheet(): UserMarkedAnswersSheetData = userMarkedAnswersSheetData

    fun setSectionResultData(sectionResultData: SectionResultData){
        this.sectionResultData = sectionResultData
    }

    fun getSectionResultData(): SectionResultData = sectionResultData

    fun setPackageType(packageType: String){
        subscriptionFormData.packageType = packageType
        updateIsSubscriptionFormFilled()
    }

    fun setPackageDuration(packageDuration: Int) {
        subscriptionFormData.packageDuration = packageDuration
    }

    fun setPackagePrice(price: String){
        subscriptionFormData.packagePrice = price
    }

    fun setMomoPartner(momoPartner: String){
        subscriptionFormData.momoPartner = momoPartner
        updateIsSubscriptionFormFilled()
    }

    fun setMomoNumber(momoNumber: String){
        subscriptionFormData.momoNumber = momoNumber
        updateIsSubscriptionFormFilled()
    }

    fun getPackageType(): String{
        return subscriptionFormData.packageType!!
    }

    fun getMomoPartner(): String{
        return subscriptionFormData.momoPartner!!
    }

    fun getPackagePrice(): String{
        return subscriptionFormData.packagePrice!!
    }

    private fun updateIsSubscriptionFormFilled() {
//
        _isSubscriptionFormFilled.value = subscriptionFormData.packageType != null && subscriptionFormData.momoPartner != null && subscriptionFormData.momoNumber != null && subscriptionFormData.momoNumber!!.length == 9
    }

    fun requestToPay() {
        CoroutineScope(Dispatchers.IO).launch {
            momoPayService.initiatePayment(subscriptionFormData)
        }

    }

    fun isPaymentSuccessful(): LiveData<Boolean>{
        return momoPayService.isTransactionSuccessful
    }

    fun activateSubjectPackage() {
        val activationExpiryDates =
            ActivationExpiryDatesGenerator.generateTrialActivationExpiryDates(
                ActivationExpiryDatesGenerator.MINUTES,
                subscriptionFormData.packageDuration!!
            )
        _subjectPackage.value?.let{
            it.packageName = subscriptionFormData.packageType
            it.activatedOn = activationExpiryDates.activatedOn
            it.expiresOn = activationExpiryDates.expiresOn
        }

        updateSubjectPackageDataInLocalDatabase(_subjectPackage.value!!)

    }

    private fun updateSubjectPackageDataInLocalDatabase(subjectPackageData: SubjectPackageData){
        CoroutineScope(Dispatchers.IO).launch{
            println(subjectPackageData)
            mcqDatabase?.subjectPackageDao()?.update(subjectPackageData)
            withContext(Dispatchers.Main){
                _isPackageActivated.value = true
            }
        }

    }

    fun setSubjectName(subjectName: String) {
        this.subjectName = subjectName
    }

    fun getSubjectName(): String{
        return subjectName
    }




}