package com.example.gceolmcq.datamodels

data class SubjectAndExpiryData(
    val position: Int,
    val subjectName: String,
    var expiresOn: String
) : java.io.Serializable
