package com.example.gceolmcq.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006J \u0010\u0015\u001a\u00020\u00132\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0005j\b\u0012\u0004\u0012\u00020\u000f`\tH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/gceolmcq/viewmodels/MainActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_liveSubjectsAvailable", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "", "liveSubjectsAvailable", "Landroidx/lifecycle/LiveData;", "Lkotlin/collections/ArrayList;", "getLiveSubjectsAvailable", "()Landroidx/lifecycle/LiveData;", "subjectAndFileNameDataListModel", "Lcom/example/gceolmcq/datamodels/SubjectAndFileNameDataListModel;", "getSubjectAndFileNameDataAt", "Lcom/example/gceolmcq/datamodels/SubjectAndFileNameData;", "position", "", "setSubjectAndFileNameDataListModel", "", "subjectsDataJsonString", "setSubjectNames", "temp", "app_release"})
public final class MainActivityViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<java.lang.String>> _liveSubjectsAvailable = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.ArrayList<java.lang.String>> liveSubjectsAvailable = null;
    private com.example.gceolmcq.datamodels.SubjectAndFileNameDataListModel subjectAndFileNameDataListModel;
    
    public MainActivityViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.ArrayList<java.lang.String>> getLiveSubjectsAvailable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SubjectAndFileNameData getSubjectAndFileNameDataAt(int position) {
        return null;
    }
    
    public final void setSubjectAndFileNameDataListModel(@org.jetbrains.annotations.Nullable()
    java.lang.String subjectsDataJsonString) {
    }
    
    private final void setSubjectNames(java.util.ArrayList<com.example.gceolmcq.datamodels.SubjectAndFileNameData> temp) {
    }
}