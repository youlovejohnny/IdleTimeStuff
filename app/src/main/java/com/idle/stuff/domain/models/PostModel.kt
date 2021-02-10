package com.idle.stuff.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.idle.stuff.view.posts.adapter.items.FeedPostItem
import com.google.gson.annotations.SerializedName

@Entity
data class PostModel(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
) {
    companion object {
        fun mapToFeedPostItem(postModel: PostModel): FeedPostItem {
            return FeedPostItem(
                postId = postModel.id,
                title = postModel.title,
                body = postModel.body
            )
        }

        fun mapToFeedPostItems(posts: List<PostModel>): List<FeedPostItem> {
            return ArrayList<FeedPostItem>().apply {
                for (post in posts) {
                    add(mapToFeedPostItem(post))
                }
            }
        }
    }
}