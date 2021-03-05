package com.idle.stuff.view.posts.adapter.delegates

import adapter_delegate.AdapterDelegate
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idle.stuff.R
import com.idle.stuff.view.posts.adapter.items.CommentsHeaderItem
import com.idle.stuff.view.posts.adapter.items.PostAdapterItem
import com.idle.stuff.view.posts.adapter.viewholders.CommentsHeaderViewHolder

class CommentsHeaderDelegate :
    AdapterDelegate<CommentsHeaderItem, PostAdapterItem, CommentsHeaderViewHolder>(PostAdapterItem.PostAdapterItemType.COMMENTS_HEADER.ordinal) {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return CommentsHeaderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_comment_header, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommentsHeaderViewHolder, item: CommentsHeaderItem) {
    }
}