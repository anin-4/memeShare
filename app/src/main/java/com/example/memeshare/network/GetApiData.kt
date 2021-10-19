package com.example.memeshare.network

import com.example.memeshare.models.MemeEntity
import com.example.memeshare.models.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GetApiData {

@GET("gimme/10")
suspend fun getAllItems():NetworkResponse
}