package com.example.gceolmcq.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gceolmcq.repository.LocalRepository
import com.example.gceolmcq.repository.RemoteRepository
import com.example.gceolmcq.repository.RepositoriesLink
import com.example.gceolmcq.roomDB.GceOLMcqDatabase
import com.parse.ParseObject

class ActivateTrialPackageFragmentViewModel: ViewModel() {

    private lateinit var repositoriesLink: RepositoriesLink

    private val _remoteRepoErrorMessage = MutableLiveData<String>()
    val remoteRepoErrorMessage: LiveData<String> = _remoteRepoErrorMessage

    private val _liveSubjectsAvailable = MutableLiveData<List<String>>()
    val subjectsAvailable: LiveData<List<String>> = _liveSubjectsAvailable

    fun setRepositoryLink(context: Context, mobileId: String){
        repositoriesLink = RepositoriesLink().apply {
            setLocalRepo(context, mobileId)
        }
    }

    fun getAreSubjectsPackagesAvailable(): LiveData<Boolean?>{
        return repositoriesLink.getAreSubjectsPackagesAvailable()
    }

    fun setSubjectNames(subjectNames: List<String>) {
        _liveSubjectsAvailable.value = subjectNames
    }

    fun readSubjectsPackagesByMobileIdFromRemoteRepo() {
        repositoriesLink.getRemoteRepository().readSubjectsPackagesByMobileIdFromRemoteRepo(_liveSubjectsAvailable.value)
    }

}