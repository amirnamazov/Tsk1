package com.example.tsk1.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup, Boolean) -> T) : Fragment() {

    protected val binding: T get() = _binding

    private lateinit var _binding: T

    override fun onCreateView(i: LayoutInflater, v: ViewGroup?, s: Bundle?): View {
        _binding = inflate.invoke(i, v!!, false)
        return _binding.root
    }
}