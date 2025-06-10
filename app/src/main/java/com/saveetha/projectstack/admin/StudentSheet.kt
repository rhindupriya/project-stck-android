package com.saveetha.projectstack.admin
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.saveetha.projectstack.databinding.FragmentStudentlistBinding
import com.saveetha.projectstack.util.studentlist

class DeveloperHomeFragment : Fragment() {
    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding: FragmentStudentlistBinding
    private var list = java.util.ArrayList<studentlist>()
    private lateinit var adapter: studentlist


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
        binding =FragmentStudentlistBinding.inflate(inflater, container, false)


        binding.textView.setOnClickListener {
            val addstudentlist = StudentNameSheet()
            addstudentlist.show(activity.supportFragmentManager, "")
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {

    }
}
