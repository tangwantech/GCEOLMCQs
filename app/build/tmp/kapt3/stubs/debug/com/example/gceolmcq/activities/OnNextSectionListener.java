package com.example.gceolmcq.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/gceolmcq/activities/OnNextSectionListener;", "", "onNextSection", "", "sectionIndex", "", "onResetCurrentSectionRetryCount", "app_debug"})
public abstract interface OnNextSectionListener {
    
    public abstract void onNextSection(int sectionIndex);
    
    public abstract void onResetCurrentSectionRetryCount();
}