package com.example.gceolmcq.datamodels

data class SubjectPackageExpiryStatusData(
    var subject: String,
    var packageName: String,
    var expiryDate: String,
    var status: Boolean
): java.io.Serializable

