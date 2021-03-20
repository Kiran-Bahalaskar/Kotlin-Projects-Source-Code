package com.adt.alphadev.firstprojectinkotlin.Recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adt.alphadev.firstprojectinkotlin.R
import com.adt.alphadev.firstprojectinkotlin.Recyclerview.Adapter.Adapter_Horizontal_Recyclerview
import kotlinx.android.synthetic.main.activity_horizontal__recyclerview.*

class ActivityHorizontal_Recyclerview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal__recyclerview)


        rv_horizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = Adapter_Horizontal_Recyclerview()
        rv_horizontal.adapter = adapter
    }
}