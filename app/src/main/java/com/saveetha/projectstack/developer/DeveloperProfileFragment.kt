package com.saveetha.projectstack.developer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.saveetha.projectstack.LoginActivity
import com.saveetha.projectstack.databinding.FragmentDeveloperProfileBinding

class DeveloperProfileFragment : Fragment() {

    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private var _binding: FragmentDeveloperProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeveloperProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        try {
            context = requireContext()
            activity = requireActivity()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // ✅ Debug: Check if logoutButton exists
        if (binding.logoutButton == null) {
            Log.e("DeveloperProfileFragment", "logoutButton is NULL!")
        } else {
            Log.d("DeveloperProfileFragment", "logoutButton found!")
        }

        // ✅ Set ClickListener for Logout Button
        binding.logoutButton.setOnClickListener {
            Log.d("DeveloperProfileFragment", "Logout button clicked!")
            logoutUser()
        }

        return view
    }

    private fun logoutUser() {
        Log.d("DeveloperProfileFragment", "Logging out user...")

        // ✅ Clear saved login details
        val preferences: SharedPreferences =
            requireActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE)
        preferences.edit().clear().apply()

        // ✅ Redirect to LoginActivity
        val intent = Intent(requireActivity(), LoginActivity::class.java)
        startActivity(intent)

        // ✅ Close current activity
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid memory leaks
    }
}
