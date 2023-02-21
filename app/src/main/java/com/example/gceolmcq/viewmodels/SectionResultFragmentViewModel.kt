package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.datamodels.*

class SectionResultFragmentViewModel: ViewModel() {
    private lateinit var sectionResultData: SectionResultData
    private lateinit var correctionData: UserMarkedAnswersSheetData
    private  val hasPerfectScore = MutableLiveData<Boolean>()


    fun setResultData(sectionResultData: SectionResultData){
        this.sectionResultData = sectionResultData
        checkForPerfectScore()
    }
    private fun checkForPerfectScore(){
        hasPerfectScore.value = sectionResultData.scoreData.percentage == 100
    }
    fun getHasPerfectScore(): LiveData<Boolean>{
        return hasPerfectScore
    }
    fun getScoreData(): ScoreData {
        return sectionResultData.scoreData
    }
    fun getSectionIndex(): Int{
        return sectionResultData.sectionIndex
    }

    fun getUserMarkedAnswersSheet(): UserMarkedAnswersSheetData {
        return sectionResultData.userMarkedAnswersSheet
    }
    fun getQuestionsWithCorrectAnswer(): UserMarkedAnswersSheetData {
        val questionsWithCorrectAnswer = ArrayList<QuestionWithUserAnswerMarkedData>()
        sectionResultData.userMarkedAnswersSheet.questionsWithUserAnswerMarkedData.forEachIndexed { _, questionWithUserAnswerMarkedData ->
            if(questionWithUserAnswerMarkedData.userSelection == null || !questionWithUserAnswerMarkedData.userSelection!!.remark!!){
                questionsWithCorrectAnswer.add(questionWithUserAnswerMarkedData)
            }
        }

        return UserMarkedAnswersSheetData(questionsWithCorrectAnswer)
    }
}