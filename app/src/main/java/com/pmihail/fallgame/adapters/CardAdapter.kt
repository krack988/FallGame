package com.pmihail.fallgame.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.pmihail.fallgame.R
import com.pmihail.fallgame.data.AnswerVariant

class CardAdapter(
    private val withHeader: Boolean = false
) : RecyclerView.Adapter<ViewHolder>() {

    val list = ArrayList<AnswerVariant>()

    override fun getItemCount() = list.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType == 0) {
        ViewHolder(parent.inflate(R.layout.row_header))
    } else {
        ViewHolder(parent.inflate(R.layout.empty_row_item))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val answer = list[position]
        holder.text.text = answer.answerText
    }
    override fun getItemViewType(position: Int) = if (withHeader && position == 0) 0 else 1

    fun updateList(list: List<AnswerVariant>?) {
        this.list.clear()
        if (list != null)
            this.list.addAll(list)
        notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var text: TextView = itemView.findViewById<TextView>(R.id.answerText)
}

private fun ViewGroup.inflate(@LayoutRes layout: Int, attach: Boolean = false) =
    LayoutInflater.from(context).inflate(layout, this, attach)