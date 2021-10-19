package com.example.memeshare.models

data class NetworkResponse(
    val count:Int,
    val memes:List<MemeEntity>
)