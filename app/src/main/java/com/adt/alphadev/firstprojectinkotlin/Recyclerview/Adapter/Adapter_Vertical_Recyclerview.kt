package com.adt.alphadev.firstprojectinkotlin.Recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.adt.alphadev.firstprojectinkotlin.R

class Adapter_Vertical_Recyclerview(private val context: Context): RecyclerView.Adapter<Adapter_Vertical_Recyclerview.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return 20
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}