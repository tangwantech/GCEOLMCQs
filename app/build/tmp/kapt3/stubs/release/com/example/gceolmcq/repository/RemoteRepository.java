package com.example.gceolmcq.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002\u00a2\u0006\u0002\u0010\u0018J(\u0010\u0019\u001a\u00020\u00122\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014H\u0002J)\u0010\u001c\u001a\u00020\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010\u0018J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\nJ\u0016\u0010\u001f\u001a\u00020\u00122\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u0016\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/gceolmcq/repository/RemoteRepository;", "", "localRepository", "Lcom/example/gceolmcq/repository/LocalRepository;", "(Lcom/example/gceolmcq/repository/LocalRepository;)V", "_areSubjectsPackagesAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "_remoteRepoErrorExceptionRaised", "mobileId", "", "remoteRepoErrorExceptionRaised", "Landroidx/lifecycle/LiveData;", "getRemoteRepoErrorExceptionRaised", "()Landroidx/lifecycle/LiveData;", "userRemoteParseObject", "Lcom/parse/ParseObject;", "insertUserSubjectsPackageDataToLocalDB", "", "tempSubjectPackageDataList", "", "Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "position", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "insertUserSubjectsPackageDataToRemoteRepo", "subjectPackageDataList", "subjectsAvailable", "readUserSubjectsPackagesFromRemoteRepoAtMobileId", "setMobileId", "id", "syncSubjectsPackageDataInRemoteRepo", "updateActivatedPackageInRemoteRepo", "subjectPackageData", "app_release"})
public final class RemoteRepository {
    private final com.example.gceolmcq.repository.LocalRepository localRepository = null;
    private androidx.lifecycle.MutableLiveData<com.parse.ParseObject> userRemoteParseObject;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _remoteRepoErrorExceptionRaised = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> remoteRepoErrorExceptionRaised = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _areSubjectsPackagesAvailable = null;
    private java.lang.String mobileId;
    
    public RemoteRepository(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.repository.LocalRepository localRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getRemoteRepoErrorExceptionRaised() {
        return null;
    }
    
    public final void setMobileId(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
    }
    
    private final void insertUserSubjectsPackageDataToRemoteRepo(java.util.List<com.example.gceolmcq.datamodels.SubjectPackageData> subjectPackageDataList, java.util.List<java.lang.String> subjectsAvailable) {
    }
    
    public final void readUserSubjectsPackagesFromRemoteRepoAtMobileId(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> subjectsAvailable, @org.jetbrains.annotations.Nullable()
    java.lang.Integer position) {
    }
    
    public final void updateActivatedPackageInRemoteRepo(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubjectPackageData subjectPackageData, int position) {
    }
    
    private final void insertUserSubjectsPackageDataToLocalDB(java.util.List<com.example.gceolmcq.datamodels.SubjectPackageData> tempSubjectPackageDataList, java.lang.Integer position) {
    }
    
    public final void syncSubjectsPackageDataInRemoteRepo(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.gceolmcq.datamodels.SubjectPackageData> subjectPackageDataList) {
    }
}