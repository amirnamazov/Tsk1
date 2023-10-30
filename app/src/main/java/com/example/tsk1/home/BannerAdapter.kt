package com.example.tsk1.home

import com.example.tsk1.base.BaseAdapter
import com.example.tsk1.databinding.ItemBannerBinding

class BannerAdapter (private val list: List<Triple<String, Int, Int>>)
    : BaseAdapter<ItemBannerBinding>(ItemBannerBinding :: inflate, list.size) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        binding.triple = list[position]
    }
}