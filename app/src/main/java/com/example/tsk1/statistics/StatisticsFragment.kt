package com.example.tsk1.statistics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentStatisticsBinding
import com.example.tsk1.util.CustomViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class StatisticsFragment :
    BaseFragment<FragmentStatisticsBinding>(FragmentStatisticsBinding::inflate) {

    private val viewModel: StatisticsViewModel by viewModels()

    private val listFrag by lazy { viewModel.list.map { TimelyFragment() } }

    private val adapter by lazy {
        CustomViewPagerAdapter(this, listFrag.mapIndexed { index, fragment ->
            fragment.apply {
                arguments = Bundle().apply {
                    putParcelableArray(LIST_ID, viewModel.list[index].second.toTypedArray())
                }
            }
        })
    }

    private val tabLayoutMediator by lazy {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = viewModel.list[position].first
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

    companion object {
        const val LIST_ID = "LIST_ID"
    }
}