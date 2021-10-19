package com.example.memeshare.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.memeshare.models.MemeEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MemeShareDao {

    @Query("select * from meme_table")
    fun getMemesFromDataBase():Flow<List<MemeEntity>>

    @Insert
    suspend fun insertMemesIntoDatabase(memes:List<MemeEntity>)

    @Query("delete from meme_table")
    suspend fun deleteMemesFromDatabase()
}