package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\rJ\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\rJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\nJ\u0016\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\nJ\u0010\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0006J\b\u0010\'\u001a\u00020\u0018H\u0002J\u0006\u0010(\u001a\u00020\u0018R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/gceolmcq/viewmodels/SplashActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_liveSubjectNames", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "", "_remoteRepoErrorExceptionRaised", "", "_serverRetryCountLeft", "", "iSubjectPackageAvailable", "liveSubjectNames", "Landroidx/lifecycle/LiveData;", "Lkotlin/collections/ArrayList;", "getLiveSubjectNames", "()Landroidx/lifecycle/LiveData;", "remoteRepoErrorExceptionRaised", "getRemoteRepoErrorExceptionRaised", "repositoriesLinker", "Lcom/example/gceolmcq/repository/RepositoriesLinker;", "subjectAndFileNameDataListModel", "Lcom/example/gceolmcq/datamodels/SubjectAndFileNameDataListModel;", "decrementServerRetryCount", "", "getAreSubjectsPackagesAvailable", "getServerRetryCountsLeft", "getSubjectAndFileNameDataAt", "Lcom/example/gceolmcq/datamodels/SubjectAndFileNameData;", "position", "resetServerRetryCount", "limit", "setRepositoryLink", "context", "Landroid/content/Context;", "mobileId", "setServerRetryCountsLeft", "setSubjectAndFileNameDataListModel", "subjectsDataJsonString", "setSubjectNames", "synchronizeSubjectsPackageData", "app_release"})
public final class SplashActivityViewModel extends androidx.lifecycle.ViewModel {
    private com.example.gceolmcq.repository.RepositoriesLinker repositoriesLinker;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> iSubjectPackageAvailable = null;
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<java.lang.String>> _liveSubjectNames = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.ArrayList<java.lang.String>> liveSubjectNames = null;
    private int _serverRetryCountLeft = 4;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _remoteRepoErrorExceptionRaised = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> remoteRepoErrorExceptionRaised = null;
    private com.example.gceolmcq.datamodels.SubjectAndFileNameDataListModel subjectAndFileNameDataListModel;
    
    public SplashActivityViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<java.lang.String>> getLiveSubjectNames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getRemoteRepoErrorExceptionRaised() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SubjectAndFileNameData getSubjectAndFileNameDataAt(int position) {
        return null;
    }
    
    public final void setSubjectAndFileNameDataListModel(@org.jetbrains.annotations.Nullable()
    java.lang.String subjectsDataJsonString) {
    }
    
    private final void setSubjectNames() {
    }
    
    public final void setRepositoryLink(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String mobileId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getAreSubjectsPackagesAvailable() {
        return null;
    }
    
    public final void synchronizeSubjectsPackageData() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> remoteRepoErrorExceptionRaised() {
        return null;
    }
    
    public final int getServerRetryCountsLeft() {
        return 0;
    }
    
    public final void setServerRetryCountsLeft(int limit) {
    }
    
    public final void decrementServerRetryCount() {
    }
    
    public final void resetServerRetryCount(int limit) {
    }
}