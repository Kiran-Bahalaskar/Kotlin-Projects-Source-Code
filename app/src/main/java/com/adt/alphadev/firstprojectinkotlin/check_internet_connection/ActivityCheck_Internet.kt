package com.adt.alphadev.firstprojectinkotlin.check_internet_connection

import android.app.Service
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R

class ActivityCheck_Internet : AppCompatActivity() {

    var context = this
    var connectivity : ConnectivityManager? = null
    var info : NetworkInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check__internet)


        connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        if ( connectivity != null)
        {
            info = connectivity!!.activeNetworkInfo

            if (info != null)
            {
                if (info!!.state == NetworkInfo.State.CONNECTED)
                {
                    Toast.makeText(context, "CONNECTED", Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(context, "NOT CONNECTED", Toast.LENGTH_LONG).show()
            }
        }

    }
}