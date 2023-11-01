package com.example.tsk1.view.statistics

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.viewModels
import androidx.palette.graphics.Palette
import com.example.tsk1.R
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentStatisticsBinding
import com.example.tsk1.model.Graph
import com.example.tsk1.util.CustomViewPagerAdapter
import com.example.tsk1.viewmodel.StatisticsViewModel
import com.google.android.material.tabs.TabLayoutMediator

class StatisticsFragment :
    BaseFragment<FragmentStatisticsBinding>(FragmentStatisticsBinding::inflate) {

    private val viewModel: StatisticsViewModel by viewModels()

    private val listFrag by lazy { viewModel.list.map { TimelyFragment() } }

    private val adapter by lazy {
        CustomViewPagerAdapter(this, listFrag.mapIndexed { index, fragment ->
            fragment.apply {
                arguments = Bundle().apply {
                    val graphArray = viewModel.list[index].third.map {
                        getGraph(it.first, it.second)
                    }.toTypedArray()

                    putString(TITLE_ID, viewModel.list[index].second)
                    putParcelableArray(LIST_ID, graphArray)
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

    private fun getGraph(drawableId: Int, title: String): Graph {
        val dominantColor = ContextCompat.getColor(requireContext(), R.color.light_green)
        val bitmap = ContextCompat.getDrawable(requireContext(), drawableId)!!.toBitmap()
        val color = Palette.from(bitmap).generate().getDominantColor(dominantColor)

        return Graph(drawableId, title, color)
    }

    companion object {
        const val TITLE_ID = "TITLE_ID"
        const val LIST_ID = "LIST_ID"
    }
}