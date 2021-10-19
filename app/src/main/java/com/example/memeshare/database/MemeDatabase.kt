package com.example.memeshare.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.memeshare.models.MemeEntity


@Database(entities = [MemeEntity::class],version = 1)
abstract class MemeDatabase:RoomDatabase() {
    abstract fun memeDaoProvider():MemeShareDao
}