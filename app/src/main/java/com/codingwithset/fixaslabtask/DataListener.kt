package com.codingwithset.fixaslabtask


interface DataListener {
    fun onStarted()
    fun onSuccess(response: List<Data>)
    fun onFailed(errorBody: String)
}