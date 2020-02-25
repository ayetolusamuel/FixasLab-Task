package com.codingwithset.fixaslabtask.network

import com.codingwithset.fixaslabtask.model.Data
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/*
handle rest-api
link: https://api.coinmarketcap.com/v1/ticker/?limit=50
 */
interface MyApi {

    @GET("ticker/")
    fun getData(
        @Query("limit")
        id: Int
    ): Call<List<Data>>

    companion object {

        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}