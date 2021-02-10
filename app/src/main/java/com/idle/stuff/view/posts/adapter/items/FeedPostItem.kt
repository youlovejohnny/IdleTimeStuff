package com.idle.stuff.view.posts.adapter.items

data class FeedPostItem(
    val postId: Int,
    val title: String,
    val body: String,
) : PostAdapterItem(PostAdapterItemType.FEED_POST)