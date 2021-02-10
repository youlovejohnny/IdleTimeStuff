package com.idle.stuff.domain.models

import com.google.gson.annotations.SerializedName

data class CommentModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("postId")
    val postId: Int,
    @SerializedName("body")
    val body: String
)
