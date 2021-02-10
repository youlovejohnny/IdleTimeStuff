package com.idle.stuff.view.posts.adapter

import com.idle.stuff.view.posts.adapter.delegates.CommentDelegate
import com.idle.stuff.view.posts.adapter.delegates.CommentsHeaderDelegate
import com.idle.stuff.view.posts.adapter.delegates.FeedPostDelegate
import com.idle.stuff.view.posts.adapter.delegates.FullPostDelegate
import com.idle.stuff.view.posts.adapter.items.PostAdapterItem

class PostAdapter(private val onPostClick: (Int) -> Unit): com.idle.stuff.view.base.BaseAdapter<PostAdapterItem>() {
    override val diffCallback = PostAdapterDiffCallback()

    override fun addDelegates() {
        delegateManager.addDelegate(FeedPostDelegate(onPostClick))
        delegateManager.addDelegate(CommentsHeaderDelegate())
        delegateManager.addDelegate(CommentDelegate())
        delegateManager.addDelegate(FullPostDelegate())
    }


}