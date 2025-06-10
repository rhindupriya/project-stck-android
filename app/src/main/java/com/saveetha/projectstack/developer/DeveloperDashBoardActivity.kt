package com.saveetha.projectstack.developer

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.ui.NavigationUI
import com.saveetha.projectstack.R
import com.saveetha.projectstack.databinding.ActivityDeveloperDashBoardBinding
import com.saveetha.projectstack.databinding.ActivityUserDasheshBoardBinding
import com.saveetha.projectstack.util.Static

class DeveloperDashBoardActivity : AppCompatActivity() {

    private lateinit var textview: TextView

    private lateinit var binding: ActivityDeveloperDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeveloperDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        NavigationUI.setupWithNavController(binding.developerBottomNavigationView, Static.getdeveloperNavController(this))

    }

    

}