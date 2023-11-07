package com.example.gceolmcq.viewmodels

import androidx.lifecycle.ViewModel
import com.example.gceolmcq.datamodels.UserMarkedAnswersSheetData

class CorrectionFragmentViewModel : ViewModel(){
    private lateinit var userMarkedAnswersSheetData: UserMarkedAnswersSheetData
    fun setUserMarkedAnswersSheetData(data: UserMarkedAnswersSheetData){
        userMarkedAnswersSheetData = data
    }
    fun getAnswerExplanationAt(position: Int): String{
        return userMarkedAnswersSheetData.questionsWithUserAnswerMarkedData[position].explanation!!
    }

    fun getUserMarkedAnswersSheetData(): UserMarkedAnswersSheetData{
        return userMarkedAnswersSheetData
    }
}