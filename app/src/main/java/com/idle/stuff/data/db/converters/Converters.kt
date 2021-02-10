package com.idle.stuff.data.db.converters

import androidx.room.TypeConverter
import com.idle.stuff.domain.models.PostModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {
    @TypeConverter
    fun postsToJson(array: List<PostModel>): String = Gson().toJson(array)

    @TypeConverter
    fun jsonToPosts(json: String): List<PostModel> = Gson().fromJson<List<PostModel>>(json)


    inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object: TypeToken<T>() {}.type)
}