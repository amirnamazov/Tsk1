package com.example.tsk1.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class CustomAdapter<T : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup, Boolean) -> T,
    private val listSize: Int,
    private val bind: (T, Int) -> Unit,
) : RecyclerView.Adapter<CustomAdapter<T>.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = inflate.invoke(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) =
        holder.bind(position)

    override fun getItemCount(): Int = listSize

    override fun getItemViewType(position: Int): Int = position

    inner class CustomViewHolder(private val item: T) : RecyclerView.ViewHolder(item.root) {
        fun bind(position: Int) = bind(item, position)
    }
}