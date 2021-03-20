package com.adt.alphadev.firstprojectinkotlin.Recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.adt.alphadev.firstprojectinkotlin.R
import com.adt.alphadev.firstprojectinkotlin.Recyclerview.Adapter.Adapter_Grid_Recyclerview
import kotlinx.android.synthetic.main.activity_grid__recyclerview.*

class ActivityGrid_Recyclerview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid__recyclerview)

        rv_grid_layout.layoutManager = GridLayoutManager(this, 2)
        val adapter = Adapter_Grid_Recyclerview()
        rv_grid_layout.adapter = adapter

    }
}