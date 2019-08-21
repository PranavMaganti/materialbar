package com.vanpra.materialbar.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Entity(tableName = "recentSearches")
data class RecentSearches(
    @PrimaryKey(autoGenerate = true)
    val searchID: Long? = null,
    val query: String
)
@Dao
interface RecentSearchesDao {
    @Query("SELECT * FROM recentSearches")
    fun getAllItems(): LiveData<List<RecentSearches>>

    @Insert(onConflict = REPLACE)
    fun insert(item: RecentSearches): Long

    @Delete
    fun deleteItem(item: RecentSearches)
}

@Database(
    entities = [(RecentSearches::class)],
    version = 1,
    exportSchema = false
)
abstract class PlaylistDB : RoomDatabase() {
    abstract fun recentSearchesDao(): RecentSearchesDao
}


