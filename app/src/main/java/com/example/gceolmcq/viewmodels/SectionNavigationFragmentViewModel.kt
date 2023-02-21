package com.example.gceolmcq.viewmodels

import androidx.core.os.persistableBundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SectionNavigationFragmentViewModel : ViewModel() {
    private var sectionNames: Array<String>? = null
    private var numberOfSections: Int? = null
    private var sectionsAnswered: List<Boolean>? = null
//    private val sectionScores = ArrayList<Int>()
    private var numberOfSectionsAnswered = MutableLiveData<Int>()
    private var score = MutableLiveData<Int>()

    private val paperScore = MutableLiveData<Int>()
    private val paperGrade = MutableLiveData<String>()
    private val areAllSectionsAnswered = MutableLiveData<Boolean>()
    private val paperPercentage = MutableLiveData<Int>()


    private var totalNumberOfQuestions: Int? = null

    init {
//        score.value = 0
        numberOfSectionsAnswered.value = 0
        paperScore.value = 0
        paperGrade.value = "U Grade"
        areAllSectionsAnswered.value = false
        paperPercentage.value = 0
    }

    fun setSectionNames(sectionNames: Array<String>?) {
        this.sectionNames = sectionNames
        setNumberOfSections()
//        initSectionScores()
    }

//    fun initSectionScores(){
//        for(index in 0..numberOfSections!!){
//            sectionScores.add(0)
//        }
//    }

    fun getSectionNames(): Array<String>? {
        return this.sectionNames
    }

    private fun setNumberOfSections() {
        numberOfSections = this.sectionNames?.size
    }

    fun getNumberOfSections(): Int? {
        return numberOfSections
    }

    fun updateSectionsAnswered(sectionsAnswered: List<Boolean>) {
        this.sectionsAnswered = sectionsAnswered
        updateNumberOfSectionsAnswered()
    }

    fun getSectionsAnswered(): List<Boolean> {
        return sectionsAnswered!!
    }

    private fun updateNumberOfSectionsAnswered() {
        numberOfSectionsAnswered.value = sectionsAnswered!!.count { it }

    }

    fun getNumberOfSectionsAnswered(): LiveData<Int> {
        return numberOfSectionsAnswered
    }

//    fun updateSectionScore(sectionIndex: Int, score: Int){
//        sectionScores[sectionIndex] = score
//    }

    fun updatePaperScore(score: Int) {
        this.paperScore.value = score
        updateGrade()
    }

    fun getPaperScore(): LiveData<Int> {
        return paperScore
    }

    fun setTotalNumberOfQuestions(numberOfQuestions: Int) {
        totalNumberOfQuestions = numberOfQuestions
    }

    fun getTotalNumberOfQuestions(): Int {
        return totalNumberOfQuestions!!
    }

    private fun updateGrade() {
//        println((paperScore.value!!.toDouble() / totalNumberOfQuestions!!.toDouble() * 100).toInt())
        if(numberOfSectionsAnswered.value == numberOfSections){
            updateAreAllSectionsAnswered()
            paperPercentage.value = (paperScore.value!!.toDouble() / totalNumberOfQuestions!!.toDouble() * 100).toInt()

            paperGrade.value = when(paperPercentage.value){
                in 75..100 -> {"A Grade"}
                in 65..74 -> {"B Grade"}
                in 50.. 64 -> {"C Grade"}
                in 40..49 -> {"D Grade"}
                in 30..39 -> {"E Grade"}
                else->{"U Grade"}
            }

        }
//        println(paperGrade.value)
    }

    fun getPaperGrade():LiveData<String>{
        return paperGrade
    }

    fun getPaperPercentage():LiveData<Int>{
        return paperPercentage
    }

    private fun updateAreAllSectionsAnswered(){
        areAllSectionsAnswered.value = true
    }

    fun getAreAllSectionsAnswered(): LiveData<Boolean>{
        return areAllSectionsAnswered
    }

}