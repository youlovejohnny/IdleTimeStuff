package com.idle.stuff.view.posts.adapter.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val commentTextView = itemView.commentTextView as TextView
}