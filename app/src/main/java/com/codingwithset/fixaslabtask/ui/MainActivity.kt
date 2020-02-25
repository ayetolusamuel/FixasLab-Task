package com.codingwithset.fixaslabtask.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithset.fixaslabtask.R
import com.codingwithset.fixaslabtask.adapter.DataAdapter
import com.codingwithset.fixaslabtask.callback.DataListener
import com.codingwithset.fixaslabtask.model.Data
import com.codingwithset.fixaslabtask.viewmodel.DataViewModelFactory
import com.codingwithset.fixaslabtask.utils.toast
import com.codingwithset.fixaslabtask.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


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




        viewModel.getData(object : DataListener {
            override fun onStarted() {
                println("onstarted")
              loading.visibility = View.VISIBLE
            }

            override fun onSuccess(response: List<Data>) {
                loading.visibility = View.INVISIBLE
                if (allData?.size == null) {
                    initView(response)
                    viewModel.insertData(response)

                }
            }

            override fun onFailed(errorBody: String) {
                println("ERROR $errorBody  ")
                if (allData?.size == null){
                    error_layout.visibility = View.VISIBLE
                }
                loading.visibility = View.GONE
                toast(errorBody)

            }

        })
        viewModel.allData.observe(this, Observer {
            if (it.isNotEmpty()) {
               loading.visibility = View.GONE
                allData = it
                initView(it)
            }

        })
    }

    private fun initView(response: List<Data>) {
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter =
            DataAdapter(context, response)
    }


}
