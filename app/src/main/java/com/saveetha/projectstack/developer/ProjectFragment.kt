package com.saveetha.projectstack.developer

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.saveetha.projectstack.databinding.FragmentLeaveBinding


class ProjectFragment : Fragment() {

    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding: FragmentLeaveBinding
    private var list = ArrayList<ProjectData>()
    private lateinit var adapter: ProjectAdapter

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
        binding = FragmentLeaveBinding.inflate(inflater, container, false)
     binding.textView2.setOnClickListener {
         var buttomsheet=AddAddressBottomSheet()
         buttomsheet.show(activity.supportFragmentManager,"")
         Toast.makeText(context, "bottom sheet", Toast.LENGTH_LONG).show()
     }
        return binding.root
    }

}
