package com.vanpra.materialbarexample
import android.annotation.SuppressLint
import android.app.Application
import android.content.ContentUris
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import java.util.concurrent.TimeUnit

class SearchViewModel(application: Application) : AndroidViewModel(application) {

    val menuItems = mutableListOf<MenuItem>()

    init {
        menuItems.add(MenuItem("Add to playlist", R.drawable.playlist_plus))
        menuItems.add(MenuItem("Edit Tag", R.drawable.pencil))
        menuItems.add(MenuItem("Delete", R.drawable.delete))
    }

    @SuppressLint("InlinedApi")
    fun extractData() = liveData {
        val songs = mutableListOf<Song>()
        val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"

        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.DISPLAY_NAME,
            MediaStore.Audio.AudioColumns.ALBUM_ID,
            MediaStore.Audio.Media.DURATION
        )

        val orderBy = MediaStore.Audio.Media.TITLE
        val cursor = getApplication<Application>().contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            null,
            "$orderBy ASC"
        )

        while (cursor!!.moveToNext()) {

            val songname = cursor.getString(2)
            var duration = cursor.getString(6)
            val artist = cursor.getString(1)
            val albumID = cursor.getString(5).toLong()
            val path = cursor.getString(3)

            duration = String.format(
                "%d min: %d sec",
                TimeUnit.MILLISECONDS.toMinutes(duration.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(duration.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(duration.toLong())
                )
            )

            val sArtworkUri = Uri.parse("content://media/external/audio/albumart")
            val uri = ContentUris.withAppendedId(sArtworkUri, albumID)

            songs.add(Song(songname, artist, duration, uri, path))
        }

        cursor.close()

        emit(songs)
    }

}