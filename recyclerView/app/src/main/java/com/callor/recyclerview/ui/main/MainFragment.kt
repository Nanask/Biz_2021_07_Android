package com.callor.recyclerview.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        _binding = MainFragmentBinding.inflate(
            inflater, container,
            false
        )
        return binding.root
    }

    // fragment를 처리하는 코드
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//    }

    private fun initRecycler() {
        listAdapter = listAdapter(this)
        binding.rcList.adapter = listAdapter

        data.apply {
            add(main_list_data("456465", "4565454", "ddd"))
            add(main_list_data("456465", "456545", "ddd1"))
            add(main_list_data("456465", "45654", "ddd2"))
            add(main_list_data("456465", "4565", "ddd3"))

            listAdapter.data = data
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}