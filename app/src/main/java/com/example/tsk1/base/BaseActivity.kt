package com.example.tsk1.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding>(private val inflate: (LayoutInflater) -> T)
    : AppCompatActivity() {

    protected val binding: T get() = _binding!!

    private var _binding: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflate.invoke(layoutInflater)
        setContentView(_binding?.root)
        initializeViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun initializeViews()
}