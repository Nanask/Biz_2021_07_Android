package com.callor.recyclerview.ui.main

import android.R
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.callor.recyclerview.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    lateinit var listAdapter: listAdapter
    val data = mutableListOf<main_list_data>()

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        mainFragment 에서 binding 할 수 있도록 처리
        _binding = MainFragmentBinding.inflate(
            inflater, container,
            false
        )


        return binding.root
    }


// onCreateView 에서 생성된 view를 처리하는 method
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        initRecycler()

//    val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
//
//    // pass it to rvLists layoutManager
//    binding.rcList.setLayoutManager(layoutManager)
//
////    // initialize the adapter,
////    // and pass the required argument
////    listAdapter = listAdapter()
//
//    // attach adapter to the recycler view
//    binding.rcList.adapter = listAdapter

    }

    // 데이터를 recyclerView에 추가하는 함수
    private fun initRecycler() {
        // 어답터 생성
        listAdapter = listAdapter(this)


// 여기서 데이터를 추가해주고
        data.apply {
            add(main_list_data("", "4565454", "ddd"))
            add(main_list_data("", "456545", "ddd1"))
            add(main_list_data("", "45654", "ddd2"))
            add(main_list_data("", "4565", "ddd3"))

            listAdapter.data = data
            //데이터를 어댑터 안에 넣는다
//            listAdapter.replaceList(data)
        }

        binding.rcList.adapter = listAdapter


        //실제 RecyclerView의 adapter를 만든 adapter로 설정한다

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

}