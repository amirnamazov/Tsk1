package com.example.tsk1.others

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentOthersBinding
import com.example.tsk1.databinding.ItemOtherBinding
import com.example.tsk1.util.CustomAdapter

class OthersFragment : BaseFragment<FragmentOthersBinding>(FragmentOthersBinding::inflate) {

    private val viewModel: OthersViewModel by viewModels()

    private val othersAdapter by lazy {
        CustomAdapter(ItemOtherBinding::inflate, viewModel.listOthers.size) { i, p ->
            i.pair = viewModel.listOthers[p]
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.root.adapter = othersAdapter
    }
}