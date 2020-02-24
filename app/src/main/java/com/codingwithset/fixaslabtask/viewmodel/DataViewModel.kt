package com.codingwithset.fixaslabtask.viewmodel

import androidx.lifecycle.ViewModel
import com.codingwithset.fixaslabtask.DataListener
import com.codingwithset.fixaslabtask.repository.DataRepository

class DataViewModel: ViewModel() {

    var dataListener: DataListener? = null


    fun getData(){
        DataRepository(dataListener!!).getData()
    }

}