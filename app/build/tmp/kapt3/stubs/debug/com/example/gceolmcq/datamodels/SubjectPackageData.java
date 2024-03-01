package com.example.gceolmcq.datamodels;

import java.lang.System;

@androidx.room.Entity(tableName = "subject_package_table")
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012JV\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001\u00a2\u0006\u0002\u0010&J\u0013\u0010\'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010)H\u00d6\u0003J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001J\t\u0010+\u001a\u00020\u0005H\u00d6\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f\u00a8\u0006,"}, d2 = {"Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "Ljava/io/Serializable;", "subjectIndex", "", "subjectName", "", "packageName", "activatedOn", "expiresOn", "isPackageActive", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getActivatedOn", "()Ljava/lang/String;", "setActivatedOn", "(Ljava/lang/String;)V", "getExpiresOn", "setExpiresOn", "()Ljava/lang/Boolean;", "setPackageActive", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPackageName", "setPackageName", "getSubjectIndex", "()Ljava/lang/Integer;", "setSubjectIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSubjectName", "setSubjectName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "equals", "other", "", "hashCode", "toString", "app_debug"})
public final class SubjectPackageData implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.PrimaryKey(autoGenerate = true)
    private java.lang.Integer subjectIndex;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "subject_name")
    private java.lang.String subjectName;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "package_name")
    private java.lang.String packageName;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "activated_on")
    private java.lang.String activatedOn;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "expires_on")
    private java.lang.String expiresOn;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "package_status")
    private java.lang.Boolean isPackageActive;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.gceolmcq.datamodels.SubjectPackageData copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer subjectIndex, @org.jetbrains.annotations.Nullable()
    java.lang.String subjectName, @org.jetbrains.annotations.Nullable()
    java.lang.String packageName, @org.jetbrains.annotations.Nullable()
    java.lang.String activatedOn, @org.jetbrains.annotations.Nullable()
    java.lang.String expiresOn, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isPackageActive) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public SubjectPackageData() {
        super();
    }
    
    public SubjectPackageData(@org.jetbrains.annotations.Nullable()
    java.lang.Integer subjectIndex, @org.jetbrains.annotations.Nullable()
    java.lang.String subjectName, @org.jetbrains.annotations.Nullable()
    java.lang.String packageName, @org.jetbrains.annotations.Nullable()
    java.lang.String activatedOn, @org.jetbrains.annotations.Nullable()
    java.lang.String expiresOn, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isPackageActive) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSubjectIndex() {
        return null;
    }
    
    public final void setSubjectIndex(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSubjectName() {
        return null;
    }
    
    public final void setSubjectName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPackageName() {
        return null;
    }
    
    public final void setPackageName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getActivatedOn() {
        return null;
    }
    
    public final void setActivatedOn(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getExpiresOn() {
        return null;
    }
    
    public final void setExpiresOn(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isPackageActive() {
        return null;
    }
    
    public final void setPackageActive(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
}