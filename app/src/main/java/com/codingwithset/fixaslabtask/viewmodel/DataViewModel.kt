package com.codingwithset.fixaslabtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codingwithset.fixaslabtask.callback.DataListener
import com.codingwithset.fixaslabtask.coroutine.Coroutines
import com.codingwithset.fixaslabtask.model.Data
import com.codingwithset.fixaslabtask.repository.DataRepository

class DataViewModel(
    private var repository: DataRepository) : ViewModel() {
    val allData: LiveData<List<Data>> = repository.getAllData()

    fun getData(listener: DataListener) {
        repository.fetchData(listener)
//        listener.onStarted()
//        Coroutines.main {
//            val response = repository.getData()
//            println("res $response")
//            if (response.isSuccessful) {
//                println("Succes    $response")
//
//                listener.onSuccess(response.body()!!)
//            } else {
//                println("failed")
//                listener.onFailed(response.errorBody().toString())
//            }
//        }

    }

    fun insertData(data:List<Data>){
       repository.insertDataList(data)
    }




}