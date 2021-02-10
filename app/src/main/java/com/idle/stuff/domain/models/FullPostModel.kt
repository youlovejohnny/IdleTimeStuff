package com.idle.stuff.domain.models

data class FullPostModel(
    val postId: Int,
    val user: UserModel,
    val title: String,
    val body: String,
    val comments: List<CommentModel>
)