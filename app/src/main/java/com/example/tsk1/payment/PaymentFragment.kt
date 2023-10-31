package com.example.tsk1.payment

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.tsk1.R
import com.example.tsk1.base.BaseFragment
import com.example.tsk1.databinding.FragmentPaymentBinding
import com.example.tsk1.databinding.ItemPaymentBinding
import com.example.tsk1.util.CustomAdapter

class PaymentFragment : BaseFragment<FragmentPaymentBinding>(FragmentPaymentBinding :: inflate) {

    private val viewModel: PaymentViewModel by viewModels()

    private val paymentAdapter by lazy {
        CustomAdapter(ItemPaymentBinding :: inflate, viewModel.list.size) { i, p ->
            i.triple = viewModel.list[p]
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvPayments.adapter = paymentAdapter
        setBtnTextSpan()
    }

    private fun setBtnTextSpan() = binding.btnAddAuto.apply {
        val color = ContextCompat.getColor(requireContext(), R.color.background)
        val (title, subtitle) = "Add auto" to "Top-Up"
        val span = SpannableString("$title\n$subtitle")
        span.setSpan(ForegroundColorSpan(color), title.length, span.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        text = span
    }
}