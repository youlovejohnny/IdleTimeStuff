package com.idle.stuff.common.di

import android.content.Context
import androidx.room.Room
import com.idle.stuff.data.db.DataBase
import com.idle.stuff.data.repository.Repository
import com.idle.stuff.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(repositoryImpl: RepositoryImpl): Repository = repositoryImpl

    @Provides
    @Singleton
    fun provideDateBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DataBase::class.java, "database.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providePostsDao(dataBase: DataBase) = dataBase.getPostsDao()

}