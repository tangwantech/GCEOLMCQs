package com.example.gceolmcq.viewmodels

import android.os.CountDownTimer
import android.text.format.Time
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.datamodels.*

class SectionFragmentViewModel : ViewModel() {
    private var sectionDataModel: SectionDataModel? = null
    private var userSelections = ArrayList<UserSelection>()
    private val letters: Array<String> = Array(4) { "" }
    private val indexPreviousAndCurrentSelectedOptionOfQuestion =
        IndexPreviousAndCurrentSelectedOptionOfQuestion()
    private val numberOfQuestionsAnswered: MutableLiveData<Int> = MutableLiveData()
    private val isQuestionAnswered = MutableLiveData<Boolean>()
    private val sectionQuestionScores: ArrayList<QuestionScore> = ArrayList()
    private var sectionScore: Int = 0
    private val milliSecPerQuestion: Long = 30000L
    private var sectionDuration: Long = 0L
    private val countDownInterval = 1000L
    private lateinit var timer: CountDownTimer
    private val questionIndex = MutableLiveData<Int>()
    private val userMarkedAnswerSheet: ArrayList<QuestionWithUserAnswerMarkedData> = ArrayList()
    private var sectionIndex: Int? = null

    private val isTimeOut = MutableLiveData<Boolean>()

    private val timeRemaining = MutableLiveData<Time>()

    private val isTimeAlmostOut = MutableLiveData<Boolean>()
    private val isTimeAlmostOutStartTime = 20000L

    init {
        letters[0] = "A"
        letters[1] = "B"
        letters[2] = "C"
        letters[3] = "D"
        numberOfQuestionsAnswered.value = 0
        questionIndex.value = 0
        isQuestionAnswered.value = false
        isTimeOut.value = false
        isTimeAlmostOut.value = false

    }

    fun getLetters():Array<String>{
        return letters
    }

    fun setSectionIndex(index:Int){
        sectionIndex = index
    }

    fun setSectionData(sectionDataModel: SectionDataModel) {
        this.sectionDataModel = sectionDataModel
        sectionDataModel.questions.shuffle()

        this.sectionDataModel!!.questions.forEachIndexed { index, _ ->
            initUserSelections()
//            initIsQuestionAnswered(index)
            initSectionQuestionScores()
            setSectionDuration()
            initUserMarkedAnswerSheet(index)
        }
        updateUserMarkedAnswerSheet()
        setQuestionCorrectAnswer()

    }

    private fun setSectionDuration() {
        sectionDuration = sectionDataModel!!.numberOfQuestions * milliSecPerQuestion
    }

    fun startTimer() {
        timer = object : CountDownTimer(sectionDuration, countDownInterval) {
            override fun onTick(p0: Long) {
                val t = Time()
                updateIsTimeAlmostOut(p0)
                t.set(p0)
                timeRemaining.value = t
            }

            override fun onFinish() {
                isTimeOut.value = true
            }

        }.start()
    }

    fun getTimeRemaining(): LiveData<Time> {
        return timeRemaining
    }

    fun updateIsTimeAlmostOut(timeLeft: Long){
        if(timeLeft < isTimeAlmostOutStartTime){
            isTimeAlmostOut.value = true
        }
    }

    fun getIsTimeAlmostOut(): LiveData<Boolean>{
        return isTimeAlmostOut
    }

    fun getIsTimeOut(): LiveData<Boolean> {
        return isTimeOut
    }

    fun getNumberOfQuestionsInSection(): Int {
        return sectionDataModel!!.numberOfQuestions
    }

    fun getNumberOfQuestionsAnswered(): LiveData<Int> {
        return numberOfQuestionsAnswered
    }

    private fun updateNumberOfQuestionsAnswered() {
        numberOfQuestionsAnswered.value = numberOfQuestionsAnswered.value!!.plus(1)
    }

    fun incrementQuestionIndex() {
        questionIndex.value = questionIndex.value!!.plus(1)
        resetIsQuestionAnswered()
        resetIndexPreviousAndCurrentItemOfQuestion()

    }

    fun getQuestionIndex(): LiveData<Int> {
        return questionIndex
    }

    private fun updateIsQuestionAnswered() {
        isQuestionAnswered.value = true
        updateNumberOfQuestionsAnswered()
    }

    private fun resetIsQuestionAnswered() {
        isQuestionAnswered.value = false
    }

    fun getIsQuestionAnswered(): LiveData<Boolean> {
        return isQuestionAnswered
    }

    private fun initUserMarkedAnswerSheet(questionIndex: Int) {
        userMarkedAnswerSheet.add(QuestionWithUserAnswerMarkedData((questionIndex + 1).toString()))
    }

    private fun initUserSelections() {
        userSelections.add(UserSelection())
    }

    private fun initSectionQuestionScores() {
        sectionQuestionScores.add(QuestionScore())
    }

    fun getQuestion(): QuestionDataModel {
        when(sectionDataModel!!.title){
            "Section I", "Section II", "Section V", "Section VI" ->{
                sectionDataModel!!.questions[questionIndex.value!!].selectableOptions.shuffle()

            }
        }
        setQuestionCorrectAnswer()
        return sectionDataModel!!.questions[questionIndex.value!!]
    }

    private fun updateUserMarkedAnswerSheet() {
        sectionDataModel!!.questions.forEachIndexed { index, questionDataModel ->
            userMarkedAnswerSheet[index].questionNumber = (index + 1).toString()
            userMarkedAnswerSheet[index].question = questionDataModel.question
            userMarkedAnswerSheet[index].image = questionDataModel.image
            userMarkedAnswerSheet[index].twoStatements = questionDataModel.twoStatements
            userMarkedAnswerSheet[index].nonSelectableOptions =
                questionDataModel.nonSelectableOptions
        }
    }

    private fun setQuestionCorrectAnswer() {
        sectionDataModel!!.questions[questionIndex.value!!].selectableOptions.forEachIndexed { index, s ->
            if (s == sectionDataModel!!.questions[questionIndex.value!!].wordAnswer) {
                userMarkedAnswerSheet[questionIndex.value!!].correctAnswer =
                    "${letters[index]}. ${sectionDataModel!!.questions[questionIndex.value!!].wordAnswer}"
            }
        }

    }

    fun getSectionTitle(): String {
        return sectionDataModel!!.title
    }

    fun updateUserSelection(optionSelectedIndex: Int) {
        val userSelection = UserSelection(
            letters[optionSelectedIndex],
            sectionDataModel!!.questions[questionIndex.value!!].selectableOptions[optionSelectedIndex]
        )
        userSelections[questionIndex.value!!] = userSelection
        userMarkedAnswerSheet[questionIndex.value!!].userSelection = userSelection

        updateIndexQuestionOptionSelected(optionSelectedIndex)
        if (!isQuestionAnswered.value!!) {
            updateIsQuestionAnswered()

        }
        evaluateUserSelections(questionIndex.value!!)
    }

    private fun evaluateUserSelections(questionIndex: Int) {
        if (userSelections[questionIndex].optionSelected == sectionDataModel!!.questions[questionIndex].wordAnswer) {
            sectionQuestionScores[questionIndex].score = 1
            userMarkedAnswerSheet[questionIndex].userSelection!!.remark = true

        } else {
            sectionQuestionScores[questionIndex].score = 0
            userMarkedAnswerSheet[questionIndex].userSelection!!.remark = false
        }

        sumSectionQuestionScores()

    }


    private fun sumSectionQuestionScores() {
        sectionScore = sectionQuestionScores.count { it.score == 1 }
    }

    fun getSectionScore(): Int {
        return sectionScore
    }

    private fun updateIndexQuestionOptionSelected(indexOptionSelected: Int) {

        if (indexPreviousAndCurrentSelectedOptionOfQuestion.indexCurrentItem == null) {
            indexPreviousAndCurrentSelectedOptionOfQuestion.indexCurrentItem = indexOptionSelected
        }

        indexPreviousAndCurrentSelectedOptionOfQuestion.indexCurrentItem?.let {
            if (indexOptionSelected != it) {
                indexPreviousAndCurrentSelectedOptionOfQuestion.indexPreviousItem = it
                indexPreviousAndCurrentSelectedOptionOfQuestion.indexCurrentItem =
                    indexOptionSelected

            }
        }

    }


    fun getIndexPreviousAndCurrentItemOfQuestion(): IndexPreviousAndCurrentSelectedOptionOfQuestion {
        return indexPreviousAndCurrentSelectedOptionOfQuestion
    }

    private fun resetIndexPreviousAndCurrentItemOfQuestion() {
        indexPreviousAndCurrentSelectedOptionOfQuestion.indexCurrentItem = null
        indexPreviousAndCurrentSelectedOptionOfQuestion.indexPreviousItem = null
    }

    fun getSectionResultData():SectionResultData{
        val percentage = ((sectionScore.toDouble() / sectionDataModel!!.numberOfQuestions.toDouble()) * 100).toInt()
        val scoreData = ScoreData(sectionScore, sectionDataModel!!.numberOfQuestions, percentage)
        val userMarkedAnswersSheetData = UserMarkedAnswersSheetData(userMarkedAnswerSheet)

        return SectionResultData(sectionIndex!!, scoreData, userMarkedAnswersSheetData)
    }


}