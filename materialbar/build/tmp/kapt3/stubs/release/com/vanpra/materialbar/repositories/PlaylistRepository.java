package com.vanpra.materialbar.repositories;

import java.lang.System;

@kotlin.Suppress(names = {"DEPRECATION"})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/vanpra/materialbar/repositories/PlaylistRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "database", "Lcom/vanpra/materialbar/database/PlaylistDB;", "addRecentSearch", "", "song", "Lcom/vanpra/materialbar/database/RecentSearches;", "(Lcom/vanpra/materialbar/database/RecentSearches;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSearch", "searchItem", "getAllRecentSearches", "Landroidx/lifecycle/LiveData;", "", "Companion", "materialbar_release"})
public final class PlaylistRepository {
    private final com.vanpra.materialbar.database.PlaylistDB database = null;
    private static com.vanpra.materialbar.repositories.PlaylistRepository INSTANCE;
    public static final com.vanpra.materialbar.repositories.PlaylistRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addRecentSearch(@org.jetbrains.annotations.NotNull
    com.vanpra.materialbar.database.RecentSearches song, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.vanpra.materialbar.database.RecentSearches>> getAllRecentSearches() {
        return null;
    }
    
    public final void deleteSearch(@org.jetbrains.annotations.NotNull
    com.vanpra.materialbar.database.RecentSearches searchItem) {
    }
    
    public PlaylistRepository(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/vanpra/materialbar/repositories/PlaylistRepository$Companion;", "", "()V", "INSTANCE", "Lcom/vanpra/materialbar/repositories/PlaylistRepository;", "instance", "context", "Landroid/content/Context;", "materialbar_release"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull
        public final com.vanpra.materialbar.repositories.PlaylistRepository instance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}