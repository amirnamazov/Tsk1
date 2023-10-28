package com.example.tsk1.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T : ViewBinding>(private val itemId: Int, private val listSize: Int) :
    RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {

    protected val binding: T get() = _binding

    private lateinit var _binding: T

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        _binding = DataBindingUtil.inflate(inflater, itemId, parent, false)
        return BaseViewHolder(_binding.root)
    }

    override fun getItemCount(): Int = listSize

    override fun getItemViewType(position: Int): Int = position

    inner class BaseViewHolder(item: View) : RecyclerView.ViewHolder(item)
}