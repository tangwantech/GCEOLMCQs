package com.example.gceolmcq.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/gceolmcq/activities/OnIsSectionAnsweredListener;", "", "onGetSectionsAnswered", "", "", "onUpdateIsSectionAnswered", "", "sectionIndex", "", "app_release"})
public abstract interface OnIsSectionAnsweredListener {
    
    public abstract void onUpdateIsSectionAnswered(int sectionIndex);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.Boolean> onGetSectionsAnswered();
}