package com.vanpra.materialbar.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ \u0010 \u001a\u00020\u000b*\u00020!2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0002J \u0010\"\u001a\u00020\u000b*\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0002R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R0\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00132\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/vanpra/materialbar/ui/SearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleRes", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backListener", "Lkotlin/Function0;", "", "getBackListener", "()Lkotlin/jvm/functions/Function0;", "setBackListener", "(Lkotlin/jvm/functions/Function0;)V", "playlistRepo", "Lcom/vanpra/materialbar/repositories/PlaylistRepository;", "value", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "resultsAdapter", "getResultsAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setResultsAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "textListener", "Lkotlin/Function1;", "", "getTextListener", "()Lkotlin/jvm/functions/Function1;", "setTextListener", "(Lkotlin/jvm/functions/Function1;)V", "afterTextChanged", "Landroid/widget/EditText;", "onTextChanged", "materialbar_debug"})
public final class SearchBar extends androidx.constraintlayout.widget.ConstraintLayout {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> textListener;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<kotlin.Unit> backListener;
    @org.jetbrains.annotations.Nullable()
    private androidx.recyclerview.widget.RecyclerView.Adapter<?> resultsAdapter;
    private final com.vanpra.materialbar.repositories.PlaylistRepository playlistRepo = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getTextListener() {
        return null;
    }
    
    public final void setTextListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function0<kotlin.Unit> getBackListener() {
        return null;
    }
    
    public final void setBackListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.recyclerview.widget.RecyclerView.Adapter<?> getResultsAdapter() {
        return null;
    }
    
    public final void setResultsAdapter(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView.Adapter<?> value) {
    }
    
    private final void afterTextChanged(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$afterTextChanged, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> afterTextChanged) {
    }
    
    private final void onTextChanged(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$onTextChanged, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTextChanged) {
    }
    
    public SearchBar(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleRes) {
        super(null);
    }
    
    public SearchBar(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public SearchBar(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
}