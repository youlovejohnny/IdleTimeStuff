package com.idle.stuff.data.db.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.idle.stuff.domain.models.PostModel

@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<PostModel>)

    @Query("SELECT * FROM PostModel")
    fun getPosts(): LiveData<List<PostModel>>

    @Query("SELECT * FROM PostModel WHERE id =:postId")
    suspend fun getPost(postId: Int): PostModel
}