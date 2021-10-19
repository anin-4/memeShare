package com.example.memeshare.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "meme_table")
data class MemeEntity(
    @PrimaryKey
    @SerializedName("author")
    val author:String,
    @SerializedName("url")
    val ImgUrl:String,
    @SerializedName("title")
    val title:String

)
