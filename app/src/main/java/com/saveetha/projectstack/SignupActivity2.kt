package com.saveetha.projectstack

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.saveetha.projectstack.databinding.ActivityMainBinding
import com.saveetha.projectstack.databinding.ActivitySignup2Binding

class SignupActivity2 : AppCompatActivity() {

        private lateinit var textview: TextView

        private lateinit var binding: ActivitySignup2Binding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySignup2Binding.inflate(layoutInflater)
            setContentView(binding.root)


    }
}