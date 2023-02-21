package com.example.gceolmcq.datamodels

import java.io.Serializable

data class SubscriptionFormDataModel(
    var subjectPosition: Int? = null,
    var subject: String? = null,
    var packageType: String? = null,
    var packageDuration: Int? = null,
    var packagePrice: String? = null,
    var momoPartner: String? = null,
    var momoNumber: String? = null,
): Serializable
