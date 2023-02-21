package com.example.gceolmcq.datamodels


data class SubjectAndFileNameDataList(val subjectAndFileNameDataArrayList: ArrayList<SubjectAndFileNameData>): java.io.Serializable

data class SubjectContents(val contents:ArrayList<ExamTypeDataModel>): java.io.Serializable

data class SubjectAndStatusData(val subject: String, val status: String="Active")



