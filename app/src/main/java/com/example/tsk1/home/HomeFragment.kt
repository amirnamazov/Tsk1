package com.example.tsk1.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.tsk1.base.BaseAdapter
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding :: inflate) {

    private val homeViewModel: HomeViewModel by viewModels()
    private val newsAdapter by lazy { NewsAdapter(listNews) }
    private val bannerAdapter by lazy { BannerAdapter(listBanner) }

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

    private val listNews: List<Pair<Int, String>> by lazy {
        homeViewModel.listNews.map { Pair(it.first, getString(it.second)) }
    }

    private val listBanner: List<Triple<String, Int, Int>> by lazy {
        homeViewModel.listBanner.map { Triple(getString(it.first), it.second, it.third) }
    }
}