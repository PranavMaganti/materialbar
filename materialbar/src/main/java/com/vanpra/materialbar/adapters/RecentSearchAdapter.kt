package com.vanpra.materialbar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vanpra.materialbar.database.RecentSearches
import com.vanpra.materialbar.R
import kotlinx.android.synthetic.main.recent_search_layout.view.*

class RecentSearchAdapter(
    private val itemListener: (RecentSearches) -> Unit,
    private val deleteListener: (RecentSearches) -> Unit
) :
    ListAdapter<RecentSearches, RecentSearchAdapter.ViewHolder>(FormatDiffer) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            parent.inflate(
                R.layout.recent_search_layout,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindItem(item)
        holder.itemView.setOnClickListener {
            itemListener(item)
        }
        holder.itemView.deleteSearch.setOnClickListener {
            deleteListener(item)
        }
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        fun bindItem(item: RecentSearches) {
            view.query.text = item.query
        }
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    object FormatDiffer : DiffUtil.ItemCallback<RecentSearches>() {
        override fun areItemsTheSame(oldItem: RecentSearches, newItem: RecentSearches): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RecentSearches, newItem: RecentSearches): Boolean {
            return oldItem == newItem
        }
    }
}
