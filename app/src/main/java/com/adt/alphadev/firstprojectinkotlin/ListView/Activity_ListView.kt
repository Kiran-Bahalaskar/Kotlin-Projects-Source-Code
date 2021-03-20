package com.adt.alphadev.firstprojectinkotlin.ListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.adt.alphadev.firstprojectinkotlin.R

class Activity_ListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__list_view)

        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "Kiran", "Komal", "Devendra", "Nitin", "Shubham", "Sachin", "Aishwarya", "Shweta"
        )


        var mListview = findViewById<ListView>(R.id.list_view)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        mListview.adapter = arrayAdapter

    }
}