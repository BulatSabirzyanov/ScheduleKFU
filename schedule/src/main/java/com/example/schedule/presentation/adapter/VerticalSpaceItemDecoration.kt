package com.example.schedule.presentation.adapter

import android.content.res.Resources
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalSpaceItemDecoration(
    spacingDp: Float
) : RecyclerView.ItemDecoration() {

    private val spacingPx: Int

    init {
        spacingPx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            spacingDp,
            Resources.getSystem().displayMetrics
        ).toInt()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val viewHolder = parent.getChildViewHolder(view)
        val currentPosition = parent.getChildAdapterPosition(view).takeIf {
            it != RecyclerView.NO_POSITION
        } ?: viewHolder.oldPosition

        outRect.top = spacingPx
        outRect.bottom = spacingPx

        if (currentPosition == 0) {
            outRect.top = spacingPx
        } else if (currentPosition == state.itemCount - 1) {
            outRect.bottom = spacingPx
        }
    }
}