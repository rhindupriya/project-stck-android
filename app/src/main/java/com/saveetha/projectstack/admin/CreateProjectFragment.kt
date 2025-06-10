package com.saveetha.projectstack.admin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.saveetha.projectstack.R
import com.saveetha.projectstack.databinding.FragmentCreateProjectBinding
import com.saveetha.projectstack.databinding.FragmentDashboardBinding
import com.saveetha.projectstack.util.Static


class
CreateProjectFragment : Fragment() {

        private lateinit var activity: FragmentActivity
        private lateinit var context: Context
        private lateinit var binding: FragmentCreateProjectBinding

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
        binding = FragmentCreateProjectBinding.inflate(inflater, container, false)

        binding.tvSubmit.setOnClickListener {

            val etTitle = binding.etTitle.text.toString()
            val etSource = binding.etSource.text.toString()
            val etDescription = binding.etDescription.text.toString()
            if(etTitle.isEmpty() || etSource.isEmpty() || etDescription.isEmpty()) {

                Toast.makeText(context, "Fill All the Fields", Toast.LENGTH_LONG).show()
            } else {

            }

        }

        binding.tvSubmit.setOnClickListener {
            Static.AdminBackStack(activity)
        }
        binding.tvCancel.setOnClickListener {
            Static.AdminBackStack(activity)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}
