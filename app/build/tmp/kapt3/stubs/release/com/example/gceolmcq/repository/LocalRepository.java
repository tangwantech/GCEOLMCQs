package com.example.gceolmcq.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\'\u0010\u0019\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b2\u0006\u0010 \u001a\u00020!R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006#"}, d2 = {"Lcom/example/gceolmcq/repository/LocalRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_areSubjectsPackagesAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "_indexOfActivatedPackage", "", "_subjectPackageData", "Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "indexOfActivatedPackage", "Landroidx/lifecycle/LiveData;", "getIndexOfActivatedPackage", "()Landroidx/lifecycle/LiveData;", "localDatabase", "Lcom/example/gceolmcq/roomDB/GceOLMcqDatabase;", "subjectPackageData", "getSubjectPackageData", "getAreSubjectsPackagesAvailable", "getSubjectPackageDataFromLocalDbWhereSubjectName", "", "subjectName", "", "insertUserSubjectsPackageDataToLocalDB", "tempSubjectPackageDataList", "", "subjectIndex", "(Ljava/util/List;Ljava/lang/Integer;)V", "syncSubjectsPackageDataFromLocalDbOffLine", "subjectNames", "remoteRepository", "Lcom/example/gceolmcq/repository/RemoteRepository;", "SubjectPackagesListener", "app_release"})
public final class LocalRepository {
    private final android.content.Context context = null;
    private final com.example.gceolmcq.roomDB.GceOLMcqDatabase localDatabase = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _areSubjectsPackagesAvailable = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _indexOfActivatedPackage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> indexOfActivatedPackage = null;
    private final androidx.lifecycle.MutableLiveData<com.example.gceolmcq.datamodels.SubjectPackageData> _subjectPackageData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.gceolmcq.datamodels.SubjectPackageData> subjectPackageData = null;
    
    public LocalRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getIndexOfActivatedPackage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.gceolmcq.datamodels.SubjectPackageData> getSubjectPackageData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getAreSubjectsPackagesAvailable() {
        return null;
    }
    
    public final void insertUserSubjectsPackageDataToLocalDB(@org.jetbrains.annotations.Nullable()
    java.util.List<com.example.gceolmcq.datamodels.SubjectPackageData> tempSubjectPackageDataList, @org.jetbrains.annotations.Nullable()
    java.lang.Integer subjectIndex) {
    }
    
    public final void getSubjectPackageDataFromLocalDbWhereSubjectName(@org.jetbrains.annotations.NotNull()
    java.lang.String subjectName) {
    }
    
    public final void syncSubjectsPackageDataFromLocalDbOffLine(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> subjectNames, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.repository.RemoteRepository remoteRepository) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/gceolmcq/repository/LocalRepository$SubjectPackagesListener;", "", "onSubjectPackagesAvailable", "", "isAvailable", "", "app_release"})
    public static abstract interface SubjectPackagesListener {
        
        public abstract void onSubjectPackagesAvailable(boolean isAvailable);
    }
}