package com.example.memeshare.di

import com.example.memeshare.network.GetApiData
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkDependency {

    @Singleton
    @Provides
    fun provideRetrofitService()= Retrofit.Builder()
        .baseUrl("https://meme-api.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(GetApiData::class.java)
}