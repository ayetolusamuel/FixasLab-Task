package com.codingwithset.fixaslabtask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithset.fixaslabtask.repository.DataRepository


@Suppress("UNCHECKED_CAST")
class DataViewModelFactory(
    private val repository: DataRepository
) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DataViewModel(repository) as T
    }
}