package com.idle.stuff.view.posts.adapter.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_full_post.view.*

class FullPostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val nameTextView = itemView.nameTextView as TextView
    val titleTextView = itemView.titleTextView as TextView
    val bodyTextView = itemView.bodyTextView as TextView
    val userNameTextView = itemView.userNameTextView as TextView

}