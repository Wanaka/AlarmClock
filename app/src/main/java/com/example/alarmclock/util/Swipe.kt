package com.example.alarmclock.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmclock.R


class Swipe {

    fun drawDelete(context: Context, c: Canvas, vH: RecyclerView.ViewHolder) {

        var swipeBackground = ColorDrawable(
            ContextCompat.getColor(
                context,
                R.color.colorRed
            )
        )
        val deleteIcon =
            context?.let { ContextCompat.getDrawable(it, R.drawable.ic_delete) }
        val itemView = vH.itemView
        val iconMargin = (itemView.height - deleteIcon!!.intrinsicHeight) / 2

        swipeBackground.setBounds(
            itemView.left,
            itemView.top,
            itemView.right,
            itemView.bottom
        )

        deleteIcon.setBounds(
            itemView.right - iconMargin - deleteIcon.intrinsicHeight,
            itemView.top + iconMargin,
            itemView.right - iconMargin,
            itemView.bottom - iconMargin
        )

        swipeBackground.draw(c)
        deleteIcon.draw(c)
    }
}