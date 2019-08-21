package com.vanpra.materialbar.ui

import android.content.Context
import android.graphics.drawable.ClipDrawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vanpra.materialbar.R
import com.vanpra.materialbar.adapters.RecentSearchAdapter
import com.vanpra.materialbar.database.RecentSearches
import com.vanpra.materialbar.repositories.PlaylistRepository
import kotlinx.android.synthetic.main.search_bar_layout.view.*
import kotlinx.coroutines.runBlocking


class SearchBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleRes) {

    var textListener: ((String) -> Unit)? = null
    var searchResultAdapter: RecyclerView.Adapter<*>? = null
    var backListener: (() -> Unit)? = null

    private val playlistRepo = PlaylistRepository.instance(context.applicationContext)

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.search_bar_layout, this, true)
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(
                it,
                R.styleable.SearchBar, 0, 0
            )
            val searchHint = typedArray.getText(R.styleable.SearchBar_search_hint)

            search_text.hint = searchHint
            typedArray.recycle()
        }

        search_text.requestFocus()
        search_text.afterTextChanged {
            if (textListener == null) {
                Log.d("ERROR", "No search text listener has been set")
            } else {
                textListener!!(it)
            }
        }

        search_text.onTextChanged {
            if (it.isEmpty()) {
                recentSearchesTxt.visibility = View.VISIBLE
                recentSearchRv.visibility = View.VISIBLE
                searchResultsRv.visibility = View.GONE
            } else {
                recentSearchesTxt.visibility = View.GONE
                recentSearchRv.visibility = View.GONE
                searchResultsRv.visibility = View.VISIBLE
            }
        }

        back.setOnClickListener {
            val listener = backListener ?: { Log.d("ERROR", "No back listener has been set") }
            listener()
        }

        search_text.setOnEditorActionListener { textView, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE) {
                search_text.clearFocus()
                val query = textView.text.toString()
                if (query != "") {
                    runBlocking {
                        playlistRepo.addRecentSearch(RecentSearches(null, textView.text.toString()))
                    }
                }
            }
            false
        }

        val recentSearchAdapter =
            RecentSearchAdapter({ recentSearch ->
                search_text.setText(recentSearch.query)
            },
                { recentSearch ->
                    playlistRepo.deleteSearch(recentSearch)
                })


        recentSearchRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
            adapter = recentSearchAdapter
            addItemDecoration(DividerItemDecoration(this.context, ClipDrawable.HORIZONTAL))
        }

        playlistRepo.getAllRecentSearches().observeForever {
            recentSearchAdapter.submitList(it)
        }

        searchResultsRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
            if (searchResultAdapter != null) {
                adapter = searchResultAdapter
            }
            addItemDecoration(DividerItemDecoration(this.context, ClipDrawable.HORIZONTAL))
        }
    }

    fun setResultsAdapter(rvAdapter:RecyclerView.Adapter<*>) {
        searchResultsRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
            adapter = rvAdapter
            addItemDecoration(DividerItemDecoration(this.context, ClipDrawable.HORIZONTAL))
        }
    }

    private fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }
        })
    }
    private fun EditText.onTextChanged(onTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                onTextChanged.invoke(p0.toString())
            }

            override fun afterTextChanged(editable: Editable?) {
            }
        })
    }

}