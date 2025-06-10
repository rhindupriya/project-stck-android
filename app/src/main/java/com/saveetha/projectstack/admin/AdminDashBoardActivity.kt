package com.saveetha.projectstack.admin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.NavigationUI
import com.saveetha.projectstack.databinding.ActivityAdminDashBoardBinding
import com.saveetha.projectstack.util.Static

class AdminDashBoardActivity : AppCompatActivity() {

    private lateinit var textview: TextView

    private lateinit var binding: ActivityAdminDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAdminDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NavigationUI.setupWithNavController(binding.adminBottomNavigationView, Static.getAdminNavController(this))

    }

}