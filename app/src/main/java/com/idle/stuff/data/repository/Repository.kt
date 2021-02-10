package com.idle.stuff.data.repository

import androidx.lifecycle.LiveData
import com.idle.stuff.domain.models.CommentModel
import com.idle.stuff.domain.models.PostModel
import com.idle.stuff.domain.models.UserModel

interface Repository {
    suspend fun getPosts(): List<PostModel>
    suspend fun savePosts(posts: List<PostModel>)
    suspend fun getUser(userId: Int): UserModel
    suspend fun getPost(postId: Int): PostModel
    fun getPostsLiveData(): LiveData<List<PostModel>>
    suspend fun getComments(postId: Int): List<CommentModel>
}