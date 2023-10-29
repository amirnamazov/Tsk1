package com.example.tsk1.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.tsk1.R
import com.example.tsk1.base.BaseAdapter
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val bannerAdapter by lazy {
        val list = listOf(
            Triple(getString(R.string.ortalama_enerji_stehlak), R.color.light_green, R.drawable.ic_banner_1),
            Triple(getString(R.string.add_auto_top_up), R.color.light_blue, R.drawable.ic_banner_2),
            Triple(getString(R.string.enerjiy_q_na_t_m_sl_h_tl_ri), R.color.light_red, R.drawable.ic_banner_3),
        )
        BannerAdapter(list)
    }

    private val newsAdapter by lazy {
        val list = listOf(
            Pair(R.drawable.img_president, getString(R.string.prezident_lham_liyev)),
            Pair(R.drawable.img_labor, getString(R.string.a_cab_dinin)),
        )
        NewsAdapter(list)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            rvBanner.setupAdapter(bannerAdapter)
            rvNews.setupAdapter(newsAdapter)
        }
    }

    private fun RecyclerView.setupAdapter(adapter: BaseAdapter<out ViewBinding>) {
        layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false)
        this.adapter = adapter
    }
}