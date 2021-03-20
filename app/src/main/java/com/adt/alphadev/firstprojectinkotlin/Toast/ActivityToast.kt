package com.adt.alphadev.firstprojectinkotlin.Toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R

class ActivityToast : AppCompatActivity() {

   private lateinit var btn_Toast : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        btn_Toast = findViewById(R.id.btn_Toast)

        btn_Toast.setOnClickListener {
            Toast.makeText(this, "Hello Kiran", Toast.LENGTH_SHORT).show()
        }

    }
}