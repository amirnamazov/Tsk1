package com.example.tsk1.view.profile

import com.example.tsk1.base.BaseActivity
import com.example.tsk1.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivity<ActivityProfileBinding>(ActivityProfileBinding::inflate) {

    override fun initializeViews() {
        setSupportActionBar(binding.toolBarMain)
        title = null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}