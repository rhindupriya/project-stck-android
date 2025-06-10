package com.saveetha.projectstack.admin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.saveetha.projectstack.R
import com.saveetha.projectstack.databinding.FragmentCreateProjectBinding
import com.saveetha.projectstack.databinding.FragmentProjectListBinding
import com.saveetha.projectstack.util.Static

class ProjectListFragment : Fragment() {

    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding:FragmentProjectListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        try {
            context = requireContext()
            activity = requireActivity()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        binding = FragmentProjectListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.textView.setOnClickListener {
            Static.adminNavigate(activity, R.id.action_projectListFragment_to_createProjectFragment)
        }
        binding.imageView6.setOnClickListener {
            Static.AdminBackStack(activity)
        }
        return binding.root
    }

}