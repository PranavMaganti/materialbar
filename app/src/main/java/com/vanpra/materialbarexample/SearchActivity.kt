package com.vanpra.materialbarexample

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import coil.api.load
import com.afollestad.assent.Permission
import com.afollestad.assent.runWithPermissions
import com.afollestad.materialdialogs.LayoutMode
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.afollestad.materialdialogs.list.customListAdapter
import com.vanpra.materialbar.ui.SearchBar
import java.io.File
import java.util.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val searchViewModel =
            ViewModelProviders.of(this).get(SearchViewModel::class.java)

        var songs = listOf<Song>()

        val searchBar = findViewById<SearchBar>(R.id.searchBar)

        val songAdapter = SongAdapter({ song : Song, _ ->
            Log.d("Song", song.toString())
        }
        ) { item, _ ->
            MaterialDialog(this, BottomSheet(LayoutMode.WRAP_CONTENT)).show {
                customView(
                    R.layout.bottom_sheet_menu,
                    scrollable = false,
                    noVerticalPadding = true
                )


                val view = this.getCustomView()
                val albumMenu = view.findViewById<ImageView>(R.id.albumMenu)
                val songMenu = view.findViewById<TextView>(R.id.title)
                val artistMenu = view.findViewById<TextView>(R.id.artistMenu)

                albumMenu.load(item.image)
                songMenu.text = item.name
                artistMenu.text = item.artist

                val itemAdapter = MenuItemAdapter { name ->
                    cancel()
                    if (name == "Delete") {
                        runWithPermissions(
                            Permission.WRITE_EXTERNAL_STORAGE,
                            Permission.READ_EXTERNAL_STORAGE
                        ) {
                            val file = File(item.path)
                            val deleted = file.delete()
                            Log.d("DELETE", deleted.toString())
                        }
                    }
                }

                customListAdapter(itemAdapter)
                itemAdapter.submitList(searchViewModel.menuItems)
            }
        }

        searchBar.apply {
            backListener = {
                finish()
            }

            textListener = { searchText ->
                val filteredSongs = songs.filter {
                    val name = it.name.toLowerCase(Locale.getDefault())
                    val search = searchText.toLowerCase(Locale.getDefault())
                    name.contains(search)
                }

                val sortedSongs = filteredSongs.sortedWith(compareBy { it.name })

                songAdapter.submitList(sortedSongs)
            }

            resultsAdapter = songAdapter
        }

        runWithPermissions(
            Permission.READ_EXTERNAL_STORAGE
        ) {
            searchViewModel.extractData().observe(this, Observer { returnedSongs ->
                Log.d("SONGS", returnedSongs.toString())
                songs = returnedSongs
            })
        }
    }
}
