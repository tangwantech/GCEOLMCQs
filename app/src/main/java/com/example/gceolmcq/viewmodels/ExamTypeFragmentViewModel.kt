package com.example.gceolmcq.viewmodels

import androidx.lifecycle.ViewModel
import com.example.gceolmcq.datamodels.ExamItemDataModel
import com.example.gceolmcq.datamodels.ExamTypeDataModel

class ExamTypeFragmentViewModel: ViewModel() {
    private lateinit var examTypeDataModel: ExamTypeDataModel

    fun setExamTypeData(examTypeDataModel: ExamTypeDataModel){
        this.examTypeDataModel = examTypeDataModel
    }

    fun getExamTypeItemsData(): ArrayList<ExamItemDataModel>{
        return examTypeDataModel.examItems
    }
    fun getExamItemDataAt(position: Int):ExamItemDataModel{
        return examTypeDataModel.examItems[position]
    }
}