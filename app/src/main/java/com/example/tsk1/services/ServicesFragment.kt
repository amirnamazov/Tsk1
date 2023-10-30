package com.example.tsk1.services

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.viewModels
import androidx.palette.graphics.Palette
import com.example.tsk1.R
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentServicesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ServicesFragment : BaseFragment<FragmentServicesBinding>(FragmentServicesBinding :: inflate) {

    private val viewModel: ServiceViewModel by viewModels()
    private val servicesAdapter by lazy { ServicesAdapter(listServices) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvServices.adapter = servicesAdapter
    }

    private val listServices: List<ServiceItem> by lazy {
        viewModel.list.map { getTriple(it.first, it.second) }
    }

    private fun getTriple(drawableId: Int, stringId: Int): Triple<Int, Int, String> {
        val dominantColor = ContextCompat.getColor(requireContext(), R.color.light_green)
        val bitmap = ContextCompat.getDrawable(requireContext(), drawableId)!!.toBitmap()
        val color = Palette.from(bitmap).generate().getDominantColor(dominantColor)
        val title = getString(stringId)

        return Triple(drawableId, color, title)
    }
}