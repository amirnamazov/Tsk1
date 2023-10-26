package com.example.tsk1

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tsk1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setInitialViews()
    }

    private fun setInitialViews() = binding.apply {
        setContentView(root)
        setSupportActionBar(toolBarMain)
        this@MainActivity.title = null
        title.text = resources.getText(R.string.home_page)
        subtitle.text = resources.getText(R.string.welcome)
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(binding.container.id)
                as NavHostFragment
        binding.bottomNav.setupWithNavController(navHostFragment.navController)

//        setupWithNavController(binding.bottomNav, binding.container.findNavController())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}