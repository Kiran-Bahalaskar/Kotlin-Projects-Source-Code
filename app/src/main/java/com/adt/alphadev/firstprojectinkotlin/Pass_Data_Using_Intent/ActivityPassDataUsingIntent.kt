package com.adt.alphadev.firstprojectinkotlin.Pass_Data_Using_Intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R

class ActivityPassDataUsingIntent : AppCompatActivity() {

    private lateinit var et_username: EditText
    private lateinit var et_email: EditText
    private lateinit var btn_send_data: Button

    private var str_et_username: String = ""
    private var str_et_email: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_data_using_intent)

        et_username = findViewById(R.id.et_username)
        et_email = findViewById(R.id.et_email)
        btn_send_data = findViewById(R.id.btn_send_data)

        btn_send_data.setOnClickListener {

            str_et_username = et_username.text.toString()
            str_et_email = et_email.text.toString()

            val passData = Intent(this, Activity_Get_Data::class.java)
            passData.putExtra("username", str_et_username)
            passData.putExtra("email", str_et_email)
            startActivity(passData)

        }

    }
}