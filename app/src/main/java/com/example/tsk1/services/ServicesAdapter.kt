package com.example.tsk1.services

import com.example.tsk1.base.BaseAdapter
import com.example.tsk1.databinding.ItemServicesBinding

class ServicesAdapter(private val list: List<Triple<Int, Int, String>>)
    : BaseAdapter<ItemServicesBinding>(ItemServicesBinding :: inflate, list.size) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        binding.triple = list[position]
    }
}