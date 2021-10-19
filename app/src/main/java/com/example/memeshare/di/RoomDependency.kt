package com.example.memeshare.di

import android.content.Context
import androidx.room.Room
import com.example.memeshare.database.MemeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomDependency {

    @Singleton
    @Provides
    fun provideDataBaseInstance(@ApplicationContext app:Context)= Room.databaseBuilder(
        app,
        MemeDatabase::class.java,
        "meme_database")
        .build()

    @Singleton
    @Provides
    fun provideDao(
        database: MemeDatabase
    ) = database.memeDaoProvider()
}