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
import com.saveetha.projectstack.databinding.FragmentAdminProfileBinding
import com.saveetha.projectstack.databinding.FragmentDeveloperProfileBinding

class AdminProfileFragment : Fragment() {

    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private var _binding: FragmentAdminProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        try {
            context = requireContext()
            activity = requireActivity()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // ✅ Debug: Check if logoutButton exists
        if (binding.logoutButton == null) {
            Log.e("AdminProfileFragment", "logoutButton is NULL!")
        } else {
            Log.d("AdminProfileFragment", "logoutButton found!")
        }

        // ✅ Set ClickListener for Logout Button
        binding.logoutButton.setOnClickListener {
            Log.d("AdminProfileFragment", "Logout button clicked!")
            logoutUser()
        }

        return view
    }

    private fun logoutUser() {
        Log.d("AdminProfileFragment", "Logging out user...")

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
