package com.vanpra.materialbar.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0016\u0017B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u0012*\u00020\u000f2\b\b\u0001\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/vanpra/materialbar/adapters/RecentSearchAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/vanpra/materialbar/database/RecentSearches;", "Lcom/vanpra/materialbar/adapters/RecentSearchAdapter$ViewHolder;", "itemListener", "Lkotlin/Function1;", "", "deleteListener", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "inflate", "Landroid/view/View;", "layoutRes", "attachToRoot", "", "FormatDiffer", "ViewHolder", "materialbar_release"})
public final class RecentSearchAdapter extends androidx.recyclerview.widget.ListAdapter<com.vanpra.materialbar.database.RecentSearches, com.vanpra.materialbar.adapters.RecentSearchAdapter.ViewHolder> {
    private final kotlin.jvm.functions.Function1<com.vanpra.materialbar.database.RecentSearches, kotlin.Unit> itemListener = null;
    private final kotlin.jvm.functions.Function1<com.vanpra.materialbar.database.RecentSearches, kotlin.Unit> deleteListener = null;
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.vanpra.materialbar.adapters.RecentSearchAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.vanpra.materialbar.adapters.RecentSearchAdapter.ViewHolder holder, int position) {
    }
    
    private final android.view.View inflate(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup $this$inflate, @androidx.annotation.LayoutRes
    int layoutRes, boolean attachToRoot) {
        return null;
    }
    
    public RecentSearchAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.vanpra.materialbar.database.RecentSearches, kotlin.Unit> itemListener, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.vanpra.materialbar.database.RecentSearches, kotlin.Unit> deleteListener) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/vanpra/materialbar/adapters/RecentSearchAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "view", "bindItem", "", "item", "Lcom/vanpra/materialbar/database/RecentSearches;", "materialbar_release"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.view.View view;
        
        public final void bindItem(@org.jetbrains.annotations.NotNull
        com.vanpra.materialbar.database.RecentSearches item) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View v) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/vanpra/materialbar/adapters/RecentSearchAdapter$FormatDiffer;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/vanpra/materialbar/database/RecentSearches;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "materialbar_release"})
    public static final class FormatDiffer extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.vanpra.materialbar.database.RecentSearches> {
        public static final com.vanpra.materialbar.adapters.RecentSearchAdapter.FormatDiffer INSTANCE = null;
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.vanpra.materialbar.database.RecentSearches oldItem, @org.jetbrains.annotations.NotNull
        com.vanpra.materialbar.database.RecentSearches newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.vanpra.materialbar.database.RecentSearches oldItem, @org.jetbrains.annotations.NotNull
        com.vanpra.materialbar.database.RecentSearches newItem) {
            return false;
        }
        
        private FormatDiffer() {
            super();
        }
    }
}