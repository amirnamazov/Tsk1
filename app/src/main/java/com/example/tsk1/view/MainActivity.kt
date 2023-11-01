package com.example.tsk1.view

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tsk1.R
import com.example.tsk1.base.BaseActivity
import com.example.tsk1.databinding.ActivityMainBinding
import com.example.tsk1.view.profile.ProfileActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun initializeViews() {
        setSupportActionBar(binding.toolBarMain)
        title = null
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