package com.example.gceolmcq.viewmodels

import androidx.lifecycle.ViewModel
import com.example.gceolmcq.datamodels.ExamItemDataModel
import com.example.gceolmcq.datamodels.ExamTypeDataModel

class SubjectStatisticsTabContentFragmentViewModel: ViewModel() {
    private lateinit var examTypeDataModel: ExamTypeDataModel

    fun setExamTypeData(examTypeDataModel: ExamTypeDataModel){
        this.examTypeDataModel = examTypeDataModel
    }

    fun getExamTypeItemsData(): ArrayList<ExamItemDataModel>{
        return examTypeDataModel.examItems
    }
    fun getExamItemTextValueAt(position: Int): String {
        return examTypeDataModel.examItems[position].title
    }
}