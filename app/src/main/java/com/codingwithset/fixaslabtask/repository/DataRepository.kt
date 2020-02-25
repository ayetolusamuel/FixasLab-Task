package com.codingwithset.fixaslabtask.repository

import androidx.lifecycle.LiveData
import com.codingwithset.fixaslabtask.coroutine.Coroutines
import com.codingwithset.fixaslabtask.database.AppDatabase
import com.codingwithset.fixaslabtask.database.DataDao
import com.codingwithset.fixaslabtask.model.Data
import com.codingwithset.fixaslabtask.network.MyApi
import retrofit2.Response

class DataRepository(
    private val myApi: MyApi,
    private val database: AppDatabase
) {


    suspend fun getData(): Response<List<Data>> {
        return myApi.getDataResponse(50)
    }

    fun insertDataList(data: List<Data>) {
        Coroutines.io {
            database.getDataDao().upSert(data)
        }
    }

    fun getAllData(): LiveData<List<Data>> {
        return database.getDataDao().getAllData()
    }


}