package com.codingwithset.fixaslabtask.repository

import com.codingwithset.fixaslabtask.Data
import com.codingwithset.fixaslabtask.DataListener
import com.codingwithset.fixaslabtask.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository(val dataListener: DataListener?) {

    fun getData(){
        dataListener?.onStarted()
        MyApi().getData(50).enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        dataListener?.onSuccess(it)
                    }

                    println("Success = "+response.body())
                }else{
                    println("Failed = "+response.errorBody())
                    dataListener?.onFailed(response.message())
                }


            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {

            }

        })
    }
}