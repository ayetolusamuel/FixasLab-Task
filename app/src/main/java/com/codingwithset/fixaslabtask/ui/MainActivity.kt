package com.codingwithset.fixaslabtask.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithset.fixaslabtask.R
import com.codingwithset.fixaslabtask.adapter.DataAdapter
import com.codingwithset.fixaslabtask.callback.DataListener
import com.codingwithset.fixaslabtask.model.Data
import com.codingwithset.fixaslabtask.repository.DataRepository
import com.codingwithset.fixaslabtask.viewmodel.DataViewModelFactory
import com.codingwithset.fixaslabtask.utils.toast
import com.codingwithset.fixaslabtask.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import java.lang.NullPointerException


class MainActivity : AppCompatActivity(), KodeinAware {

    //kodein for DI
    override val kodein by kodein()

    val dataViewModelFactory: DataViewModelFactory by instance()

    var allData: List<Data>? = null

    lateinit var viewModel: DataViewModel
    lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        context = applicationContext
        viewModel = ViewModelProvider(this, dataViewModelFactory).get(DataViewModel::class.java)

        viewModel.allData.observe(this, Observer {


            if (it.isNotEmpty()) {
                allData = it
                initView(it)
            }

        })


        viewModel.getData(object :
            DataListener {
            override fun onStarted() {
                println("onstarted")
            }

            override fun onSuccess(response: List<Data>) {

               if (allData?.size == null){
                   initView(response)
                   viewModel.insertData(response)

               }
            }

            override fun onFailed(errorBody: String) {
                println("failed")
                toast(errorBody)

            }

        })

    }

    private fun initView(response: List<Data>) {
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter =
            DataAdapter(context, response)
    }


}
