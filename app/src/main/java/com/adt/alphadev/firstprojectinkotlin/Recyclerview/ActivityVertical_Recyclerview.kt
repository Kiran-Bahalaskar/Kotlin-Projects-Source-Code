package com.adt.alphadev.firstprojectinkotlin.Recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.adt.alphadev.firstprojectinkotlin.R
import com.adt.alphadev.firstprojectinkotlin.Recyclerview.Adapter.Adapter_Vertical_Recyclerview
import kotlinx.android.synthetic.main.activity_vertical__recyclerview.*

class ActivityVertical_Recyclerview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical__recyclerview)

        rv_vertical.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter_Vertical_Recyclerview(this)
        rv_vertical.adapter = adapter

    }
}