package com.pmihail.fallgame.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.pmihail.fallgame.R

class CardAdapter(
    private val withHeader: Boolean = false
) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount() = 64
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType == 0) {
        ViewHolder(parent.inflate(R.layout.row_header))
    } else {
        ViewHolder(parent.inflate(R.layout.empty_row_item))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = Unit
    override fun getItemViewType(position: Int) = if (withHeader && position == 0) 0 else 1
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

private fun ViewGroup.inflate(@LayoutRes layout: Int, attach: Boolean = false) =
    LayoutInflater.from(context).inflate(layout, this, attach)