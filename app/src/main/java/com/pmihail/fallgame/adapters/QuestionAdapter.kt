package com.pmihail.fallgame.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.pmihail.fallgame.R
import com.pmihail.fallgame.data.AnswerVariant

class QuestionAdapter : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    var list: List<AnswerVariant> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.row_empty_card))
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun updateItems(list: List<AnswerVariant>) {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
        private fun ViewGroup.inflate(@LayoutRes layout: Int, attach: Boolean = false) =
            LayoutInflater.from(context).inflate(layout, this, attach)

}
