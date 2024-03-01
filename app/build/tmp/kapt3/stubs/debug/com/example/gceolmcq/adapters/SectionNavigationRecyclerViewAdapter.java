package com.example.gceolmcq.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001d\u001eB1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u001c\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u001e\u0010\u001c\u001a\u00020\u00152\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter$ViewHolder;", "context", "Landroid/content/Context;", "listSections", "", "Landroid/os/Bundle;", "listener", "Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter$OnRecyclerItemClickListener;", "sectionsAnswered", "", "", "(Landroid/content/Context;[Landroid/os/Bundle;Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter$OnRecyclerItemClickListener;Ljava/util/List;)V", "[Landroid/os/Bundle;", "sectionScores", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateSectionScore", "OnRecyclerItemClickListener", "ViewHolder", "app_debug"})
public final class SectionNavigationRecyclerViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter.ViewHolder> {
    private final android.content.Context context = null;
    private final android.os.Bundle[] listSections = null;
    private final com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter.OnRecyclerItemClickListener listener = null;
    private final java.util.List<java.lang.Boolean> sectionsAnswered = null;
    private java.util.ArrayList<java.lang.Integer> sectionScores;
    
    public SectionNavigationRecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.os.Bundle[] listSections, @org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter.OnRecyclerItemClickListener listener, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Boolean> sectionsAnswered) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.gceolmcq.adapters.SectionNavigationRecyclerViewAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateSectionScore(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> sectionScores) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter;Landroid/view/View;)V", "scoreLo", "Landroid/widget/LinearLayout;", "getScoreLo", "()Landroid/widget/LinearLayout;", "sectionNavItemLayout", "getSectionNavItemLayout", "tvSectionNavItem", "Landroid/widget/TextView;", "getTvSectionNavItem", "()Landroid/widget/TextView;", "tvSectionNumberOfQuestions", "getTvSectionNumberOfQuestions", "tvSectionScore", "getTvSectionScore", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvSectionNavItem = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvSectionNumberOfQuestions = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout sectionNavItemLayout = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.LinearLayout scoreLo = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvSectionScore = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvSectionNavItem() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvSectionNumberOfQuestions() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getSectionNavItemLayout() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.LinearLayout getScoreLo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvSectionScore() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/gceolmcq/adapters/SectionNavigationRecyclerViewAdapter$OnRecyclerItemClickListener;", "", "onRecyclerItemClick", "", "position", "", "app_debug"})
    public static abstract interface OnRecyclerItemClickListener {
        
        public abstract void onRecyclerItemClick(int position);
    }
}