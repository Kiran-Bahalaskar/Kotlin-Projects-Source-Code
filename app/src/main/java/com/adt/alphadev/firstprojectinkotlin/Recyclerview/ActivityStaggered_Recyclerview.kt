package com.adt.alphadev.firstprojectinkotlin.Recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.adt.alphadev.firstprojectinkotlin.R
import com.adt.alphadev.firstprojectinkotlin.Recyclerview.Adapter.Adapter_Staggered_Recyclerview
import com.google.zxing.common.GridSampler
import kotlinx.android.synthetic.main.activity_staggered__recyclerview.*

class ActivityStaggered_Recyclerview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staggered__recyclerview)

        rv_staggered.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val adapter = Adapter_Staggered_Recyclerview(this)

        rv_staggered.adapter = adapter


    }
}