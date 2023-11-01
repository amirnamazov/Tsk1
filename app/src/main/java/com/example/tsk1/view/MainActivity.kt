package com.example.tsk1.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tsk1.R
import com.example.tsk1.databinding.ActivityMainBinding
import com.example.tsk1.view.profile.ProfileActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setInitialViews()
    }

    private fun setInitialViews() = binding.apply {
        setContentView(root)
        setSupportActionBar(toolBarMain)
        this@MainActivity.title = null
        setBottomNavigation()
    }

    private fun setBottomNavigation() = binding.apply {
        val navHostFragment = supportFragmentManager.findFragmentById(container.id)
                as NavHostFragment
        navHostFragment.navController.addOnDestinationChangedListener { _, dest, _ ->
            binding.fragmentLabel = dest.label.toString()
        }
        bottomNav.setupWithNavController(navHostFragment.navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_profile -> {
                val intent = Intent(this, ProfileActivity :: class.java)
                startActivity(intent)
                true
            }
            else -> false
        }
    }
}