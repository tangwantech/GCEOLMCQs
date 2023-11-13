package com.example.gceolmcq.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.ActivationExpiryDatesGenerator
import com.example.gceolmcq.MCQConstants
import com.example.gceolmcq.MomoPayService
import com.example.gceolmcq.datamodels.*
import com.example.gceolmcq.repository.RepositoriesLinker
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.google.gson.Gson
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class MainActivityViewModel : ViewModel() {
    private val _liveSubjectsAvailable = MutableLiveData<ArrayList<String>>()
    val liveSubjectsAvailable: LiveData<ArrayList<String>> = _liveSubjectsAvailable
    private lateinit var subjectAndFileNameDataListModel: SubjectAndFileNameDataListModel

    fun getSubjectAndFileNameDataAt(position: Int): SubjectAndFileNameData {
        return subjectAndFileNameDataListModel.subjectAndFileNameDataList[position]
    }

    fun setSubjectAndFileNameDataListModel(subjectsDataJsonString: String?) {
        subjectAndFileNameDataListModel =
            Gson().fromJson(subjectsDataJsonString!!, SubjectAndFileNameDataListModel::class.java)
        val subjectAndFile = subjectAndFileNameDataListModel.subjectAndFileNameDataList
        setSubjectNames(subjectAndFile)

    }

    private fun setSubjectNames(temp: ArrayList<SubjectAndFileNameData>) {
        val tempSubjectNames = ArrayList<String>()
        temp.forEach {
            tempSubjectNames.add(it.subject)
        }

        _liveSubjectsAvailable.value = tempSubjectNames
    }
}

