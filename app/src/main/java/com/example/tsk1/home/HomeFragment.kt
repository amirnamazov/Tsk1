package com.example.tsk1.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentHomeBinding
import com.example.tsk1.databinding.ItemBannerBinding
import com.example.tsk1.databinding.ItemNewsBinding
import com.example.tsk1.util.CustomAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding :: inflate) {

    private val homeViewModel: HomeViewModel by viewModels()

    private val newsAdapter by lazy {
        CustomAdapter(ItemNewsBinding :: inflate, listNews.size) {i, p ->
            i.pair = listNews[p]
        }
    }
    private val bannerAdapter by lazy {
        CustomAdapter(ItemBannerBinding :: inflate, listBanner.size) {i, p ->
            i.triple = listBanner[p]
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            rvBanner.adapter = bannerAdapter
            rvNews.adapter = newsAdapter
        }
    }

    private val listNews: List<Pair<Int, String>> by lazy {
        homeViewModel.listNews.map { Pair(it.first, getString(it.second)) }
    }

    private val listBanner: List<Triple<String, Int, Int>> by lazy {
        homeViewModel.listBanner.map { Triple(getString(it.first), it.second, it.third) }
    }
}