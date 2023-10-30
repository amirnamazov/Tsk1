package com.example.tsk1.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup, Boolean) -> T, private val listSize: Int) :
    RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {

    protected val binding: T get() = _binding

    private lateinit var _binding: T

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        _binding = inflate.invoke(inflater, parent, false)
        return BaseViewHolder(_binding.root)
    }

    override fun getItemCount(): Int = listSize

    override fun getItemViewType(position: Int): Int = position

    inner class BaseViewHolder(item: View) : RecyclerView.ViewHolder(item)
}