package com.example.tsk1.statistics

import android.os.Build
import android.os.Bundle
import android.view.View
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentTimelyBinding
import com.example.tsk1.databinding.ItemStatisticsBinding
import com.example.tsk1.model.Graph
import com.example.tsk1.statistics.StatisticsFragment.Companion.TITLE_ID
import com.example.tsk1.util.CustomAdapter

class TimelyFragment : BaseFragment<FragmentTimelyBinding>(FragmentTimelyBinding::inflate) {

    private val title by lazy {
        requireArguments().getString(TITLE_ID)
    }

    private val listGraph by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelableArray(StatisticsFragment.LIST_ID, Graph :: class.java)
        } else {
            requireArguments().getParcelableArray(StatisticsFragment.LIST_ID)
        } as Array<Graph>
    }

    private val adapter by lazy {
        CustomAdapter(ItemStatisticsBinding::inflate, listGraph.size) { i, p ->
            i.graph = listGraph[p]
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.title.text = title
        binding.rvYearly.adapter = adapter
    }
}