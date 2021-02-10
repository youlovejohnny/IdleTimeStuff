package com.idle.stuff.view.posts.adapter.viewholders

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_feed_post.view.*

class FeedPostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val titleTextView = itemView.titleTextView as TextView
    val bodyTextView = itemView.bodyTextView as TextView
    val rootConstraintLayout = itemView.rootConstraintLayout as ConstraintLayout

    var postId = 0
}