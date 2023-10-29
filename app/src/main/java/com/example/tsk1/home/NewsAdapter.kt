package com.example.tsk1.home

import com.example.tsk1.R
import com.example.tsk1.base.BaseAdapter
import com.example.tsk1.databinding.ItemNewsBinding

class NewsAdapter(private val list: List<Pair<Int, String>>)
    : BaseAdapter<ItemNewsBinding>(R.layout.item_news, list.size) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        binding.pair = list[position]
    }
}