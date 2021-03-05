package com.idle.stuff.view.posts.adapter.delegates

import adapter_delegate.AdapterDelegate
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idle.stuff.R
import com.idle.stuff.view.posts.adapter.items.PostAdapterItem
import com.idle.stuff.view.posts.adapter.items.FeedPostItem
import com.idle.stuff.view.posts.adapter.viewholders.FeedPostViewHolder

class FeedPostDelegate(private val onPostClick: (Int) -> Unit) :
    AdapterDelegate<FeedPostItem, PostAdapterItem, FeedPostViewHolder>(PostAdapterItem.PostAdapterItemType.FEED_POST.ordinal) {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return FeedPostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        ).apply {
            rootConstraintLayout.setOnClickListener { onPostClick(postId) }
        }
    }

    override fun onBindViewHolder(holderFeed: FeedPostViewHolder, item: FeedPostItem) {
        holderFeed.titleTextView.text = item.title
        holderFeed.bodyTextView.text = item.body
        holderFeed.postId = item.postId
    }
}