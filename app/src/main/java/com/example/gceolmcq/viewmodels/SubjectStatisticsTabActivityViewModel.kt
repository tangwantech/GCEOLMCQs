package com.example.gceolmcq.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gceolmcq.datamodels.ExamItemDataModel
import com.example.gceolmcq.datamodels.ExamTypeDataModel
import com.example.gceolmcq.datamodels.StatisticsData
import com.example.gceolmcq.datamodels.SubjectData
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubjectStatisticsTabActivityViewModel: ViewModel() {
    private lateinit var gceOLMcqDatabase: GceOLMcqDatabase
    private lateinit var subjectData: SubjectData
    private val examTitles: ArrayList<String?> = ArrayList()
    private val examContents: HashMap<Int, ArrayList<String>?> = HashMap()
    private var statisticsData = MutableLiveData<StatisticsData?>()

    fun setDataBase(gceOLMcqDatabase: GceOLMcqDatabase){
        this.gceOLMcqDatabase = gceOLMcqDatabase
    }

    fun initSubjectContentsData(jsonFile: String){
        subjectData = Gson().fromJson(jsonFile, SubjectData::class.java)
        setExamTitles()
    }

    private fun setExamTitles(){
        subjectData.contents!!.forEachIndexed { index, examTypeData ->
            examTitles.add(examTypeData.title)
            setExamContents(examTypeData, index)
        }
    }

    private fun setExamContents(examTypeDataModel: ExamTypeDataModel, index: Int) {
        val examContents: ArrayList<String> = ArrayList()

        examTypeDataModel.examItems.forEach {
            examContents.add(it.title)

        }
        this.examContents[index] = examContents

    }


    fun getExamTypesCount(): Int {
        return(subjectData.contents!!.size)
    }

    fun getExamTypeDataAt(position: Int): ExamTypeDataModel {
        return (subjectData.contents!![position])
    }

    fun getExamTitles(): ArrayList<String?> {
        return examTitles
    }

    fun queryStatisticsDataTableByCustomId(customId: String){
        var tempStatisticsData: StatisticsData?
        viewModelScope.launch(Dispatchers.IO) {

//            mcqDatabase?.statisticsDataDao()?.deleteAll()
            tempStatisticsData = gceOLMcqDatabase.statisticsDataDao().findByCustomId(customId)
            statisticsData.postValue(tempStatisticsData)
            withContext(Dispatchers.Main){
            }


        }

    }
    fun getStatisticsData(): LiveData<StatisticsData?>{
        return statisticsData
    }
}
