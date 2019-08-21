package com.vanpra.materialbar.repositories

import android.content.Context
import androidx.lifecycle.liveData
import androidx.room.Room
import com.vanpra.materialbar.database.PlaylistDB
import com.vanpra.materialbar.database.RecentSearches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Suppress("DEPRECATION")
class PlaylistRepository(context: Context) {
    private val database = Room
        .databaseBuilder(context.applicationContext, PlaylistDB::class.java, "playlistitem")
        .build()

    suspend fun addRecentSearch(song: RecentSearches) {
        withContext(Dispatchers.IO) {
            database.recentSearchesDao().insert(song)
        }
    }

    fun getAllRecentSearches() = liveData {
        emitSource(database.recentSearchesDao().getAllItems())
    }

    fun deleteSearch(searchItem: RecentSearches) {
        GlobalScope.launch {
            database.recentSearchesDao().deleteItem(searchItem)
        }
    }



    companion object {
        private var INSTANCE: PlaylistRepository? = null

        fun instance(context: Context): PlaylistRepository {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = PlaylistRepository(context)
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

