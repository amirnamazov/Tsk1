package com.example.tsk1.statistics

import android.os.Build
import android.os.Bundle
import android.view.View
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentTimelyBinding
import com.example.tsk1.databinding.ItemStatisticsBinding
import com.example.tsk1.model.Graph
import com.example.tsk1.util.CustomAdapter

class TimelyFragment : BaseFragment<FragmentTimelyBinding>(FragmentTimelyBinding::inflate) {

    private val listGraph by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelableArray(StatisticsFragment.LIST_ID, Graph :: class.java)
        } else {
            requireArguments().getParcelableArray(StatisticsFragment.LIST_ID)
        } as Array<Graph>
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.rvYearly.adapter = CustomAdapter(
            ItemStatisticsBinding::inflate, listGraph.size
        ) { i, p -> i.graph = listGraph[p] }
    }
}