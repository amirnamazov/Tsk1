package com.example.tsk1.statistics

import android.os.Bundle
import android.view.View
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentStatisticsBinding
import com.example.tsk1.statistics.monthly.MonthlyFragment
import com.example.tsk1.statistics.yearly.YearlyFragment
import com.example.tsk1.util.CustomViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class StatisticsFragment : BaseFragment<FragmentStatisticsBinding>(FragmentStatisticsBinding::inflate) {

    private val listFrag by lazy {
        listOf("Yearly" to YearlyFragment(), "Monthly" to MonthlyFragment())
    }

    private val adapter by lazy {
        CustomViewPagerAdapter(this, listFrag.map { it.second })
    }

    private val tabLayoutMediator by lazy {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = listFrag[position].first
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = adapter
        tabLayoutMediator.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tabLayoutMediator.detach()
    }
}