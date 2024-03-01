package com.example.gceolmcq.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0017\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/gceolmcq/repository/RepositoriesLinker;", "", "()V", "_areSubjectsPackagesAvailable", "Landroidx/lifecycle/MutableLiveData;", "", "localRepository", "Lcom/example/gceolmcq/repository/LocalRepository;", "remoteRepository", "Lcom/example/gceolmcq/repository/RemoteRepository;", "getAreSubjectsPackagesAvailable", "Landroidx/lifecycle/LiveData;", "getIndexOfActivatedPackage", "", "getLocalRepository", "getRemoteRepository", "initAreSubjectsPackagesAvailable", "", "setLocalRepo", "context", "Landroid/content/Context;", "mobileId", "", "setRemoteRepo", "app_debug"})
public final class RepositoriesLinker {
    private com.example.gceolmcq.repository.LocalRepository localRepository;
    private com.example.gceolmcq.repository.RemoteRepository remoteRepository;
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> _areSubjectsPackagesAvailable;
    
    public RepositoriesLinker() {
        super();
    }
    
    public final void setLocalRepo(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String mobileId) {
    }
    
    private final void initAreSubjectsPackagesAvailable() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getAreSubjectsPackagesAvailable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getIndexOfActivatedPackage() {
        return null;
    }
    
    private final void setRemoteRepo(java.lang.String mobileId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.repository.LocalRepository getLocalRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.repository.RemoteRepository getRemoteRepository() {
        return null;
    }
}