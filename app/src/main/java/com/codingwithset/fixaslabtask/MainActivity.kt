package com.codingwithset.fixaslabtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.codingwithset.fixaslabtask.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash_screen.*

class MainActivity : AppCompatActivity(), DataListener {

   lateinit var  viewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        getData()
        viewModel.dataListener = this




    }

    fun  getData(){
        viewModel.getData()
    }

    override fun onStarted() {
        loading.show()
        toast("on started")

    }

    override fun onSuccess(response: List<Data>) {
        loading.hide()
        toast("DATA### $response")

    }

    override fun onFailed(errorBody: String) {
        loading.hide()
        toast("Error message $errorBody" )
    }


}
