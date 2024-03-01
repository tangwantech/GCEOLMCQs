package com.example.gceolmcq.roomDB;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/example/gceolmcq/roomDB/SubjectPackageDao;", "", "deleteAll", "", "findBySubjectName", "Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "subjectName", "", "getAllSubjectsPackages", "", "insert", "subjectPackageData", "update", "", "app_debug"})
public abstract interface SubjectPackageDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubjectPackageData subjectPackageData);
    
    @androidx.room.Update()
    public abstract int update(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.datamodels.SubjectPackageData subjectPackageData);
    
    @androidx.room.Query(value = "DELETE FROM subject_package_table")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM subject_package_table")
    public abstract java.util.List<com.example.gceolmcq.datamodels.SubjectPackageData> getAllSubjectsPackages();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM subject_package_table WHERE subject_name LIKE :subjectName")
    public abstract com.example.gceolmcq.datamodels.SubjectPackageData findBySubjectName(@org.jetbrains.annotations.NotNull()
    java.lang.String subjectName);
}