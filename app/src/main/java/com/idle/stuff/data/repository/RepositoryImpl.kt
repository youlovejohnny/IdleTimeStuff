package com.idle.stuff.data.repository

import androidx.lifecycle.LiveData
import com.idle.stuff.data.db.daos.PostsDao
import com.idle.stuff.data.network.RetrofitClient
import com.idle.stuff.domain.models.CommentModel
import com.idle.stuff.domain.models.PostModel
import com.idle.stuff.domain.models.UserModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val retrofitClient: RetrofitClient,
    private val postsDao: PostsDao,
) : Repository {


    override suspend fun getPosts(): List<PostModel> {
        return retrofitClient.getPosts()
    }

    override suspend fun getPost(postId: Int): PostModel {
        return postsDao.getPost(postId)
    }

    override suspend fun savePosts(posts: List<PostModel>) {
       postsDao.insertPosts(posts)
    }

    override fun getPostsLiveData(): LiveData<List<PostModel>> {
        return postsDao.getPosts()
    }

    override suspend fun getUser(userId: Int): UserModel {
        return retrofitClient.getUser(userId)
    }

    override suspend fun getComments(postId: Int): List<CommentModel> {
        return retrofitClient.getComments(postId)
    }


}