package com.example.gceolmcq.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.AssertReader
import com.example.gceolmcq.datamodels.PackageData
import com.example.gceolmcq.datamodels.PackagesData
import com.google.gson.Gson

class PackageDialogViewModel: ViewModel() {
    private val packages = ArrayList<PackageData>()
    private var selectedPackage: PackageData? = null

    fun setPackages(jsonData: String){

        val packagesData = Gson().fromJson(jsonData, PackagesData::class.java)
        packages.addAll(packagesData.packages)

    }

    fun getPackages(): ArrayList<PackageData>{
        return packages
    }

    fun updatePackageDataAt(position: Int, isChecked: Boolean){
        for (index in 0 until packages.size){
            if( index == position){
                packages[index].isChecked = isChecked
            }else{
                packages[index].isChecked = false
            }
        }
        println(packages)
    }

    fun getSelectedPackage(): PackageData{
        return packages.first { it.isChecked }
    }

    fun clearPackages(){
        packages.clear()
    }

}