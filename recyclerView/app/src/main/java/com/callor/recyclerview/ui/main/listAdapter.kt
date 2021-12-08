package com.callor.recyclerview.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.callor.recyclerview.R
import com.callor.recyclerview.databinding.ListItemBinding

class listAdapter(private val context: MainFragment) : RecyclerView.Adapter<listAdapter.ListViewHolder>() {


    class ListViewHolder( private val binding : ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        // view에 데이터를 넣는 부분  binding한 데이터를 넣겠다!
        fun bind(item : main_list_data) {
            binding.tvTitle.text = item.tv_title
            binding.tvContent.text = item.tv_content

        }
    }

    // 데이터를 저장할 것
    var data = mutableListOf<main_list_data>()

    // 화면에서 보이기 위한 method
    // ViewHolder에 쓰일 Layout을 inflate하는 함수
    // ViewGroup의 context를 사용하여 특정 화면에서 구현할 수 있도록 함
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view = LayoutInflater.from(context.context)
//            .inflate(R.layout.list_item,parent,false)

//        val layoutInflater = LayoutInflater.from(parent.context)

//        val binding = DataBindingUtil.inflate(layoutInflater,R.layout.main_fragment,parent,false)
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//            .from(context).inflate(R.layout.list_item,parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: listAdapter.ListViewHolder, position: Int) {
        // 리스트를 holder에 binding 해주는 것
        holder.bind(data[position])

    }

// 데이터를 묶는 함수가 실행되는 곳
    override fun getItemCount(): Int {
        return data.size


    }

    fun replaceList(newList: MutableList<main_list_data>) {
        data = newList.toMutableList()
        //어댑터의 데이터가 변했다는 notify를 날린다
        notifyDataSetChanged()
    }



}