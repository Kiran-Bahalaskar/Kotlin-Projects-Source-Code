package com.adt.alphadev.firstprojectinkotlin.Session_Management

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.adt.alphadev.firstprojectinkotlin.R
import com.adt.alphadev.firstprojectinkotlin.Session_Management.Session.SessionManager

class ActivityWelcome : AppCompatActivity() {

    private lateinit var tv_username: TextView
    private lateinit var tv_email: TextView
    private lateinit var btn_logout: Button

    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        session = SessionManager(this)

        tv_username = findViewById(R.id.tv_username)
        tv_email = findViewById(R.id.tv_email)
        btn_logout = findViewById(R.id.btn_logout)


        session.checkLogin()

        var user: HashMap<String, String> = session.getUserDetails()

        var name = user.get(SessionManager.KEY_NAME)
        var email = user.get(SessionManager.KEY_EMAIL)

        tv_username.setText("Username: "+ name)
        tv_email.setText("Email: "+ email)

        btn_logout.setOnClickListener {
                session.LogoutUser()
        }

    }
}