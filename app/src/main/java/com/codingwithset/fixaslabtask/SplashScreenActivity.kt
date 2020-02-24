package com.codingwithset.fixaslabtask

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity() : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            startActivity(Intent(applicationContext, MainActivity::class.java))
            overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left)
            finish()
        }, 1000)
    }
}


