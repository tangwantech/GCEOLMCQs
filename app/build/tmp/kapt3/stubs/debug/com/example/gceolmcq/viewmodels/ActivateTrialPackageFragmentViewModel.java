package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\tJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006J\u0014\u0010\u0018\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/example/gceolmcq/viewmodels/ActivateTrialPackageFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_liveSubjectsAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "", "_remoteRepoErrorMessage", "remoteRepoErrorMessage", "Landroidx/lifecycle/LiveData;", "getRemoteRepoErrorMessage", "()Landroidx/lifecycle/LiveData;", "repositoriesLinker", "Lcom/example/gceolmcq/repository/RepositoriesLinker;", "subjectsAvailable", "getSubjectsAvailable", "getAreSubjectsPackagesAvailable", "", "readSubjectsPackagesByMobileIdFromRemoteRepo", "", "setRepositoryLink", "context", "Landroid/content/Context;", "mobileId", "setSubjectNames", "subjectNames", "app_debug"})
public final class ActivateTrialPackageFragmentViewModel extends androidx.lifecycle.ViewModel {
    private com.example.gceolmcq.repository.RepositoriesLinker repositoriesLinker;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _remoteRepoErrorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> remoteRepoErrorMessage = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _liveSubjectsAvailable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> subjectsAvailable = null;
    
    public ActivateTrialPackageFragmentViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getRemoteRepoErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getSubjectsAvailable() {
        return null;
    }
    
    public final void setRepositoryLink(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String mobileId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getAreSubjectsPackagesAvailable() {
        return null;
    }
    
    public final void setSubjectNames(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> subjectNames) {
    }
    
    public final void readSubjectsPackagesByMobileIdFromRemoteRepo() {
    }
}