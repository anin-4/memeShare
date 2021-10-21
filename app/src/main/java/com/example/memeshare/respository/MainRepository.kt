package com.example.memeshare.respository

import androidx.room.withTransaction
import com.example.memeshare.database.MemeDatabase
import com.example.memeshare.database.MemeShareDao
import com.example.memeshare.network.GetApiData
import com.example.memeshare.utils.networkBoundResource
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val memeDatabase: MemeDatabase,
    private val memeShareDao: MemeShareDao,
    private val apiCalls:GetApiData
) {
    fun getAllData() = networkBoundResource(
        query = { memeShareDao.getMemesFromDataBase()},
        fetch = { apiCalls.getAllItems()},
        saveFetchResult = {
            val theMemes = it.memes
            memeDatabase.withTransaction {
                memeShareDao.deleteMemesFromDatabase()
                memeShareDao.insertMemesIntoDatabase(theMemes)
            }
        },
    )

}