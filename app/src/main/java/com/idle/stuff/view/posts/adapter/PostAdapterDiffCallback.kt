package com.idle.stuff.view.posts.adapter

import com.idle.stuff.view.base.BaseDiffCallback
import com.idle.stuff.view.posts.adapter.items.CommentsHeaderItem
import com.idle.stuff.view.posts.adapter.items.FullPostItem
import com.idle.stuff.view.posts.adapter.items.PostAdapterItem
import com.idle.stuff.view.posts.adapter.items.FeedPostItem

class PostAdapterDiffCallback : BaseDiffCallback<PostAdapterItem>() {
    override fun areItemsTheSame(oldItem: PostAdapterItem, newItem: PostAdapterItem): Boolean {
        if (oldItem is FeedPostItem && newItem is FeedPostItem) {
            return oldItem.postId == newItem.postId
        } else if (oldItem is FullPostItem && newItem is FullPostItem) {
            return oldItem.postId == newItem.postId
        } else if (oldItem is CommentsHeaderItem && newItem is CommentsHeaderItem) {
            return true
        } else {
            return false
        }
    }

    override fun areContentsTheSame(oldItem: PostAdapterItem, newItem: PostAdapterItem): Boolean {
        if (oldItem is FeedPostItem && newItem is FeedPostItem) {
            if (oldItem.body != newItem.body) return false
            if (oldItem.title != newItem.title) return false
            return true
        } else if (oldItem is FullPostItem && newItem is FullPostItem) {
            if (oldItem.body != newItem.body) return false
            if (oldItem.title != newItem.title) return false
            if (oldItem.realName != newItem.realName) return false
            if (oldItem.userName != newItem.userName) return false
            return true
        } else if (oldItem is CommentsHeaderItem && newItem is CommentsHeaderItem) {
            return true
        } else {
            return false
        }
    }
    
}