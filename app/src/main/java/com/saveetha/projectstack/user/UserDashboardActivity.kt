package com.saveetha.projectstack.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.TextView
import com.saveetha.projectstack.databinding.ActivityUserDasheshBoardBinding

class UserDashboardActivity : AppCompatActivity() {

    private lateinit var textview: TextView

    private lateinit var binding: ActivityUserDasheshBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDasheshBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}