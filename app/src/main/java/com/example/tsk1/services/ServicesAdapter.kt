package com.example.tsk1.services

import com.example.tsk1.R
import com.example.tsk1.base.BaseAdapter
import com.example.tsk1.databinding.ItemServicesBinding
import javax.inject.Inject

class ServicesAdapter @Inject constructor(private val list: List<Triple<Int, Int, String>>)
    : BaseAdapter<ItemServicesBinding>(R.layout.item_services, list.size) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        binding.triple = list[position]
    }
}