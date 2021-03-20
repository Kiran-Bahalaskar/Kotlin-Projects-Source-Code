package com.adt.alphadev.firstprojectinkotlin.IntroSlider

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.adt.alphadev.firstprojectinkotlin.R

class ActivitySplashScreen_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        setContentView(R.layout.activity_splash_screen_2)


        Handler().postDelayed(object : Runnable{
            override fun run() {
                startActivity(Intent(this@ActivitySplashScreen_2, Activity_IntroSlider::class.java))
                finish()
            }
        }, 2500)
    }
}