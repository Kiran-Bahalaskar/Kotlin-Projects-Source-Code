package com.adt.alphadev.firstprojectinkotlin.check_internet_connection


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.adt.alphadev.firstprojectinkotlin.R
import com.adt.alphadev.firstprojectinkotlin.check_internet_connection.Connection_Class.NetworkConnection
import kotlinx.android.synthetic.main.activity__check__internet__connection.*

class Activity_Check_Internet_Connection : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__check__internet__connection)


        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer { isConnected ->

            if (isConnected){
                layoutDisconnected.visibility = View.GONE
                layoutConnected.visibility = View.VISIBLE
            }else{
                layoutConnected.visibility = View.GONE
                layoutDisconnected.visibility = View.VISIBLE
            }
        })

    }

}