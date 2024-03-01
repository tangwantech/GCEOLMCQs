package com.example.gceolmcq.datamodels

data class PackagesData(
    var packages: ArrayList<PackageData>
)

data class PackageData(
    var packageName: String,
    var price: String,
    var duration: Int,
    var isChecked: Boolean=false
): java.io.Serializable
