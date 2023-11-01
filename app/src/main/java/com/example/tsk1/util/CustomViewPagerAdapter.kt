package com.example.tsk1.util

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomViewPagerAdapter(frag: Fragment, private val list: List<Fragment>) :
    FragmentStateAdapter(frag) {

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment = list[position]
}