package com.adt.alphadev.firstprojectinkotlin.Session_Management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R
import com.adt.alphadev.firstprojectinkotlin.Session_Management.Session.SessionManager

class ActivitySession_Management : AppCompatActivity() {

    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var et_email: EditText
    private lateinit var btn_login: Button

    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session__management)

        session = SessionManager(this)
        if (session.isLoggedIn()){
            var i: Intent = Intent(applicationContext, ActivityWelcome::class.java)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(i)
            finish()
        }

        et_username = findViewById(R.id.et_username)
        et_email = findViewById(R.id.et_email)
        et_password = findViewById(R.id.et_password)
        btn_login = findViewById(R.id.btn_login)


        btn_login.setOnClickListener {

            var username = et_username.text.toString().trim()
            var password = et_password.text.toString().trim()
            var email = et_email.text.toString().trim()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
                session.createLoginSession(username, email)
                var i: Intent = Intent(applicationContext, ActivityWelcome::class.java)
                startActivity(i)
                finish()

            }else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }

        }
    }
}