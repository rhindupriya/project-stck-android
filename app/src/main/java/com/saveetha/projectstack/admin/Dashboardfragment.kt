package com.saveetha.projectstack.admin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.saveetha.projectstack.R
import com.saveetha.projectstack.databinding.FragmentDashboardBinding
import com.saveetha.projectstack.util.Static

class Dashboardfragment : Fragment() {

    private lateinit var activity:FragmentActivity
    private lateinit var context:Context
    private lateinit var binding:FragmentDashboardBinding

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


        binding = FragmentDashboardBinding.inflate(inflater, container, false)

        binding.imageView3.setOnClickListener {
            Static.adminNavigate(activity, R.id.action_admin_home_to_projectListFragment)
        }
        binding.imageView2.setOnClickListener {
            Static.adminNavigate(activity, R.id.action_admin_home_to_developerListFragment)
        }
        binding.imageView.setOnClickListener {
            Static.adminNavigate(activity, R.id.action_admin_home_to_teamListFragment2)
        }

        binding.imageView4.setOnClickListener {
            Static.adminNavigate(activity, R.id.action_admin_home_to_studentlistFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {

    }
}