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
    var rowCount:Int? = 0


    fun getData(listener: DataListener) {
        listener.onStarted()
        Coroutines.main {
            val response = repository.getData()
            if (response.isSuccessful) {
                listener.onSuccess(response.body()!!)
            } else {
                listener.onFailed(response.errorBody().toString())
            }
        }

    }

    fun insertData(data:List<Data>){
      repository.getDataCount()
       repository.insertDataList(data)
    }




}