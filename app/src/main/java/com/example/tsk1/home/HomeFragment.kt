package com.example.tsk1.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tsk1.R
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val list by lazy {
        listOf(
            Triple(getString(R.string.ortalama_enerji_stehlak), R.color.light_green, R.drawable.ic_banner_1),
            Triple(getString(R.string.add_auto_top_up), R.color.light_blue, R.drawable.ic_banner_2),
            Triple(getString(R.string.enerjiy_q_na_t_m_sl_h_tl_ri), R.color.light_red, R.drawable.ic_banner_3),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setBannerAdapter()
    }

    private fun setBannerAdapter() = binding.rvBanner.apply {
        layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false)
        adapter = BannerAdapter(list)
    }
}