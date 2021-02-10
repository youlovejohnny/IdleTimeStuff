package com.idle.stuff.data.network

import com.idle.stuff.domain.models.CommentModel
import com.idle.stuff.domain.models.PostModel
import com.idle.stuff.domain.models.UserModel
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitClient {
    @GET("/posts")
    suspend fun getPosts(): List<PostModel>

    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): UserModel

    @GET("/posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int): List<CommentModel>

}