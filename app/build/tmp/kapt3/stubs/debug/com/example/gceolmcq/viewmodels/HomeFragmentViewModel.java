package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0011\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00120\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/example/gceolmcq/viewmodels/HomeFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_packageExpiredIndex", "Landroidx/lifecycle/MutableLiveData;", "", "_subjectPackageDataList", "Ljava/util/ArrayList;", "Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "gceOLMcqDatabase", "Lcom/example/gceolmcq/roomDB/GceOLMcqDatabase;", "localRepo", "Lcom/example/gceolmcq/repository/LocalRepository;", "packageExpiredIndex", "Landroidx/lifecycle/LiveData;", "getPackageExpiredIndex", "()Landroidx/lifecycle/LiveData;", "subjectPackageDataList", "Lkotlin/collections/ArrayList;", "getSubjectPackageDataList", "initGceOLMcqDatabase", "", "context", "Landroid/content/Context;", "initSubjectPackagesDataListFromLocalDatabase", "app_debug"})
public final class HomeFragmentViewModel extends androidx.lifecycle.ViewModel {
    private com.example.gceolmcq.roomDB.GceOLMcqDatabase gceOLMcqDatabase;
    private com.example.gceolmcq.repository.LocalRepository localRepo;
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.example.gceolmcq.datamodels.SubjectPackageData>> _subjectPackageDataList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.ArrayList<com.example.gceolmcq.datamodels.SubjectPackageData>> subjectPackageDataList = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _packageExpiredIndex = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> packageExpiredIndex = null;
    
    public HomeFragmentViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<com.example.gceolmcq.datamodels.SubjectPackageData>> getSubjectPackageDataList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getPackageExpiredIndex() {
        return null;
    }
    
    public final void initGceOLMcqDatabase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void initSubjectPackagesDataListFromLocalDatabase() {
    }
}