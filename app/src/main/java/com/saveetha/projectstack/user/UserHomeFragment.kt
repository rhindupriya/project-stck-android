package com.saveetha.projectstack.user

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.saveetha.projectstack.databinding.FragmentUserHomeBinding

class UserHomeFragment : Fragment() {
    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding: FragmentUserHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            context = requireContext()
            activity = requireActivity()
        } catch (e:Exception) {
            e.printStackTrace()
        }
        binding = FragmentUserHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

}




