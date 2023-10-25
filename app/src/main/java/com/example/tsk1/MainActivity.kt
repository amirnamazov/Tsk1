package com.example.tsk1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.example.tsk1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setInitialViews()
    }

    private fun setInitialViews() {
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarMain)
        binding.title.text = "382969235483594835834759843754398573948347599999999999999"
//        supportActionBar?.apply {
//            title = "382969235483594835834759843754398573948347599999999999999"
//            subtitle = "6666666666666666666666663333333333333"
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}