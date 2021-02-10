package com.idle.stuff.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.citrix.coroutinestest.R
import com.idle.stuff.utils.ResExtractor

class PostsDecorator: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val topMargin =
            if (parent.getChildAdapterPosition(view) == 0) {
                ResExtractor.getDimen(R.dimen.defaultMarginDouble)
            } else {
                ResExtractor.getDimen(R.dimen.defaultMarginOne)
            }

        val bottomMargin =
            ResExtractor.getDimen(R.dimen.defaultMarginOne)

        outRect.top = topMargin.toInt()
        outRect.bottom = bottomMargin.toInt()
    }
}