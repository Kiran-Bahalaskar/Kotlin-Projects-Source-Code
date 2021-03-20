package com.adt.alphadev.firstprojectinkotlin.Recyclerview.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adt.alphadev.firstprojectinkotlin.R

class Adapter_Grid_Recyclerview(): RecyclerView.Adapter<Adapter_Grid_Recyclerview.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 20
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}