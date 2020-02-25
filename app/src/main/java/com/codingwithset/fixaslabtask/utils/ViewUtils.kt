package com.codingwithset.fixaslabtask.utils

import android.content.Context
import android.opengl.Visibility
import android.view.View
import android.widget.Toast

fun Context.toast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

