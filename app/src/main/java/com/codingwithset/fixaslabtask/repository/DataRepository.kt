package com.codingwithset.fixaslabtask.repository

import androidx.lifecycle.LiveData
import com.codingwithset.fixaslabtask.callback.DataListener
import com.codingwithset.fixaslabtask.coroutine.Coroutines
import com.codingwithset.fixaslabtask.database.AppDatabase
import com.codingwithset.fixaslabtask.model.Data
import com.codingwithset.fixaslabtask.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository(
    private val myApi: MyApi,
    private val database: AppDatabase
) {


    fun fetchData(listener: DataListener) {
        listener.onStarted()
        myApi.getData(50).enqueue(object : Callback<List<Data>> {
            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                listener.onFailed(t.message.toString())
            }

            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {

                if (response.isSuccessful)
                    listener.onSuccess(response.body()!!)
            }

        })
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