package com.example.gceolmcq.datamodels

data class SubjectData(
    val title: String,
    val contents: ArrayList<ExamTypeDataModel>? = null
): java.io.Serializable
