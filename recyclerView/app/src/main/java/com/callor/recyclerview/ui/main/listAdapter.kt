package com.callor.recyclerview.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.callor.recyclerview.R

class listAdapter(private val context: MainFragment) : RecyclerView.Adapter<listAdapter.ListViewHolder>() {

    class ListViewHolder(view : View): RecyclerView.ViewHolder(view) {
        fun bind(item : main_list_data) {

        }
    }

    var data = mutableListOf<main_list_data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(context.context)
            .inflate(R.layout.list_item,parent,false)

//            .from(context).inflate(R.layout.list_item,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: listAdapter.ListViewHolder, position: Int) {
        TODO("Not yet implemented")
        // 리스트를 holder에 binding 해주는 것
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return data.size
    }


}