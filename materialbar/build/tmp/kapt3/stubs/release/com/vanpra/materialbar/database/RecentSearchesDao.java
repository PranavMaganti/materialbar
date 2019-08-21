package com.vanpra.materialbar.database;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/vanpra/materialbar/database/RecentSearchesDao;", "", "deleteItem", "", "item", "Lcom/vanpra/materialbar/database/RecentSearches;", "getAllItems", "Landroidx/lifecycle/LiveData;", "", "insert", "", "materialbar_release"})
public abstract interface RecentSearchesDao {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM recentSearches")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.vanpra.materialbar.database.RecentSearches>> getAllItems();
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract long insert(@org.jetbrains.annotations.NotNull
    com.vanpra.materialbar.database.RecentSearches item);
    
    @androidx.room.Delete
    public abstract void deleteItem(@org.jetbrains.annotations.NotNull
    com.vanpra.materialbar.database.RecentSearches item);
}