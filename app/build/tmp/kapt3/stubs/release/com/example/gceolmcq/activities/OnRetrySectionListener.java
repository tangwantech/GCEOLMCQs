package com.example.gceolmcq.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/example/gceolmcq/activities/OnRetrySectionListener;", "", "onDecrementCurrentSectionRetryCount", "", "onGetCurrentSectionRetryCount", "Landroidx/lifecycle/LiveData;", "", "onRetrySection", "sectionIndex", "app_release"})
public abstract interface OnRetrySectionListener {
    
    public abstract void onRetrySection(int sectionIndex);
    
    public abstract void onDecrementCurrentSectionRetryCount();
    
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> onGetCurrentSectionRetryCount();
}