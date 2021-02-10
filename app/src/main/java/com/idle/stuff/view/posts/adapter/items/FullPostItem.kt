package com.idle.stuff.view.posts.adapter.items

data class FullPostItem(
    val postId: Int,
    val realName: String,
    val userName: String,
    val title: String,
    val body: String
): PostAdapterItem(PostAdapterItemType.FULL_POST) {
}