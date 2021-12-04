package com.callor.recyclerview.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.callor.recyclerview.R
import com.callor.recyclerview.databinding.ListItemBinding

class listAdapter(private val context: MainFragment) : RecyclerView.Adapter<listAdapter.ListViewHolder>() {

    class ListViewHolder( private val binding : ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item : main_list_data) {
            binding.tvTitle.text = item.tv_title
            binding.tvContent.text = item.tv_content

        }
    }

    var data = mutableListOf<main_list_data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view = LayoutInflater.from(context.context)
//            .inflate(R.layout.list_item,parent,false)

        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//            .from(context).inflate(R.layout.list_item,parent,false)
        return ListViewHolder(binding)
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