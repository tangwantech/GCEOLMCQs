package com.example.gceolmcq.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0012\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u0016H\u0014J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0016H\u0014J\b\u0010\'\u001a\u00020\u0016H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0016H\u0002J\b\u0010/\u001a\u00020\u0016H\u0002J\b\u00100\u001a\u00020\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/example/gceolmcq/activities/SubjectContentTableActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/gceolmcq/fragments/ExamTypeFragment$OnPackageExpiredListener;", "Lcom/example/gceolmcq/fragments/ExamTypeFragment$OnContentAccessDeniedListener;", "()V", "alertDialog", "Landroidx/appcompat/app/AlertDialog$Builder;", "currentTabIndex", "", "pref", "Landroid/content/SharedPreferences;", "selectedTab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "subjectContentTableViewModel", "Lcom/example/gceolmcq/viewmodels/SubjectContentTableViewModel;", "subjectTitle", "", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "exitActivity", "", "getJsonFromAssets", "fileName", "initActivityViews", "initViewModel", "onBackPressed", "onCheckIfPackageHasExpired", "", "onContentAccessDenied", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onShowPackageExpired", "saveSelectedTab", "index", "setAlertDialog", "setUpSubjectContentTab", "subjectPackageData", "Lcom/example/gceolmcq/datamodels/SubjectPackageData;", "setupActivityViewListeners", "setupViewObservers", "showAlertDialog", "Companion", "app_debug"})
public final class SubjectContentTableActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.gceolmcq.fragments.ExamTypeFragment.OnPackageExpiredListener, com.example.gceolmcq.fragments.ExamTypeFragment.OnContentAccessDeniedListener {
    private com.example.gceolmcq.viewmodels.SubjectContentTableViewModel subjectContentTableViewModel;
    private java.lang.String subjectTitle;
    private com.google.android.material.tabs.TabLayout tabLayout;
    private com.google.android.material.tabs.TabLayout.Tab selectedTab;
    private androidx.viewpager.widget.ViewPager viewPager;
    private androidx.appcompat.app.AlertDialog.Builder alertDialog;
    private android.content.SharedPreferences pref;
    private int currentTabIndex = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gceolmcq.activities.SubjectContentTableActivity.Companion Companion = null;
    private static final java.lang.String SUBJECT_CONTENT_TABLE = "subject content table";
    private static final java.lang.String TAB_INDEX = "tab index";
    
    public SubjectContentTableActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initActivityViews() {
    }
    
    private final void initViewModel() {
    }
    
    private final void setupViewObservers() {
    }
    
    private final void setAlertDialog() {
    }
    
    private final void showAlertDialog() {
    }
    
    private final void exitActivity() {
    }
    
    private final void setUpSubjectContentTab(com.example.gceolmcq.datamodels.SubjectPackageData subjectPackageData) {
    }
    
    private final void setupActivityViewListeners() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final java.lang.String getJsonFromAssets(java.lang.String fileName) {
        return null;
    }
    
    @java.lang.Override()
    public void onShowPackageExpired() {
    }
    
    @java.lang.Override()
    public boolean onCheckIfPackageHasExpired() {
        return false;
    }
    
    @java.lang.Override()
    public void onContentAccessDenied() {
    }
    
    private final void saveSelectedTab(int index) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/gceolmcq/activities/SubjectContentTableActivity$Companion;", "", "()V", "SUBJECT_CONTENT_TABLE", "", "TAB_INDEX", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}