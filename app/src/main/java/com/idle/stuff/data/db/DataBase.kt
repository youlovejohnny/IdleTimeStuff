package com.idle.stuff.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.idle.stuff.data.db.converters.Converters
import com.idle.stuff.data.db.daos.PostsDao
import com.idle.stuff.domain.models.PostModel
import com.idle.stuff.domain.models.UserModel

@Database(entities = [PostModel::class, UserModel::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DataBase : RoomDatabase() {

    abstract fun getPostsDao(): PostsDao
}