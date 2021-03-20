package com.adt.alphadev.firstprojectinkotlin.Validation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R

class ActivityValidation : AppCompatActivity() {

    private lateinit var et_username: EditText
    private lateinit var et_mail: EditText
    private lateinit var et_password: EditText
    private lateinit var btn_validate: Button

    private var str_et_username: String = ""
    private var str_et_mail: String = ""
    private var str_et_password: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validation)

        et_username = findViewById(R.id.et_username)
        et_mail = findViewById(R.id.et_mail)
        et_password = findViewById(R.id.et_password)
        btn_validate = findViewById(R.id.btn_validate)

        btn_validate.setOnClickListener {

            str_et_username = et_username.text.toString().trim()
            str_et_mail = et_mail.text.toString().trim()
            str_et_password = et_password.text.toString().trim()

            if (str_et_username.length == 0){

                et_username.setError("Enter Username")
                et_username.requestFocus()

            }else if (str_et_mail.length == 0){

                et_mail.setError("Enter Email")
                et_mail.requestFocus()

            }else if (str_et_password.length == 0){

                et_password.setError("Enter Password")
                et_password.requestFocus()

            }else {
                Toast.makeText(applicationContext, "Validate Your Fields", Toast.LENGTH_SHORT).show()
            }

        }

    }
}