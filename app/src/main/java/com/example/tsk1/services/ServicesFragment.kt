package com.example.tsk1.services

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentServicesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ServicesFragment : BaseFragment<FragmentServicesBinding>(FragmentServicesBinding :: inflate) {

    private val viewModel: ServiceViewModel by viewModels()
    private val servicesAdapter by lazy { ServicesAdapter(viewModel.list) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvServices.setupAdapter()
    }

    private fun RecyclerView.setupAdapter() {
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        adapter = servicesAdapter
    }
}