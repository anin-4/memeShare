package com.example.memeshare.network

import com.example.memeshare.models.MemeEntity
import retrofit2.http.GET
import retrofit2.http.Path


interface GetApiData {

    @GET("gimme/{itemCount}")
    suspend fun getMemesFromNetwork(
        @Path(
            value = "itemCount",
            encoded = true) itemCount:Int):List<MemeEntity>
}