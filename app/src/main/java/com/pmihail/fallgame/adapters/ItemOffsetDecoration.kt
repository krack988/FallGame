package com.pmihail.fallgame.adapters

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pmihail.fallgame.R

class ItemOffsetDecoration(
    context: Context? = null
) :  RecyclerView.ItemDecoration(){
    private val spacing = context?.resources?.getDimensionPixelOffset(R.dimen.default_spacing_large) ?: 0
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val adapter = parent.adapter ?: return
        val vh = parent.findContainingViewHolder(view) ?: return
        val isFirst = vh.adapterPosition == 0
        val isLast = vh.adapterPosition == adapter.itemCount - 1
//        if (withHeader) {
//            when {
//                isFirst -> outRect.set(0, 0, 0, spacing / 2)
//                isLast -> outRect.set(spacing, spacing / 2, spacing, spacing)
//                else -> outRect.set(spacing, spacing / 2, spacing, spacing / 2)
//            }
//        } else {
            when {
                isFirst -> outRect.set(spacing, spacing, spacing, spacing / 2)
                isLast -> outRect.set(spacing, spacing / 2, spacing, spacing)
                else -> outRect.set(spacing, spacing / 2, spacing, spacing / 2)
            }
//        }
    }


}