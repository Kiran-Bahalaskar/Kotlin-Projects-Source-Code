package com.adt.alphadev.firstprojectinkotlin.Pass_Data_Using_Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.adt.alphadev.firstprojectinkotlin.R

class Activity_Get_Data : AppCompatActivity() {

    private lateinit var tv_get_username: TextView
    private lateinit var tv_get_email: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__get__data)

        tv_get_username = findViewById(R.id.tv_get_username)
        tv_get_email = findViewById(R.id.tv_get_email)


        var str_username : String? = intent.getStringExtra("username")
        var str_email : String? = intent.getStringExtra("email")

        tv_get_username.setText(str_username)
        tv_get_email.setText(str_email)


    }
}