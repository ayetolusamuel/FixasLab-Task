package com.codingwithset.fixaslabtask

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.codingwithset.fixaslabtask.customview.HorizontalDottedProgress

fun Context.toast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}


fun HorizontalDottedProgress.show(){
    visibility = View.VISIBLE
}

fun HorizontalDottedProgress.hide(){
    visibility = View.GONE
}