package com.adt.alphadev.firstprojectinkotlin.SnackBar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adt.alphadev.firstprojectinkotlin.R
import com.google.android.material.snackbar.Snackbar

class ActivitySnack_bar : AppCompatActivity() {

    private lateinit var btnSnackBar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar)

        btnSnackBar = findViewById(R.id.btnSnackBar);

        btnSnackBar.setOnClickListener {


            val snackBar = Snackbar.make(
                it, "Replace With Your own Action",
                Snackbar.LENGTH_LONG
            ).setAction("Action", null)
            snackBar.setActionTextColor(Color.BLUE)
            val snackbarView = snackBar.view
            snackbarView.setBackgroundColor(Color.CYAN)
            snackBar.show()

        }

    }
}