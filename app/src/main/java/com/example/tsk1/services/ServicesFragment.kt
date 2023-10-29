package com.example.tsk1.services

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.tsk1.R
import com.example.tsk1.base.BaseAdapter
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentServicesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ServicesFragment : BaseFragment<FragmentServicesBinding>(R.layout.fragment_services) {

    @Inject lateinit var servicesAdapter: ServicesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvServices.setupAdapter(servicesAdapter)
    }

    private fun RecyclerView.setupAdapter(adapter: BaseAdapter<out ViewBinding>) {
        layoutManager = GridLayoutManager(requireContext(), 2,
            GridLayoutManager.VERTICAL, false)
        this.adapter = adapter
    }
}