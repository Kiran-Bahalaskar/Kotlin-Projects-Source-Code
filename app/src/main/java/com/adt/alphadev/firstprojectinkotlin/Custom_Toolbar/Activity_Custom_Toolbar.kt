package com.adt.alphadev.firstprojectinkotlin.Custom_Toolbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.adt.alphadev.firstprojectinkotlin.R

class Activity_Custom_Toolbar : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__custom__toolbar)

        toolbar = findViewById(R.id.my_toolbar)
        toolbar.title = "My Toolbar"
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

    }
}