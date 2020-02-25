package com.codingwithset.fixaslabtask.callback

import com.codingwithset.fixaslabtask.model.Data


interface DataListener {
    fun onStarted()
    fun onSuccess(response: List<Data>)
    fun onFailed(errorBody: String)
}