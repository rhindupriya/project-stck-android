package com.saveetha.projectstack.developer

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.saveetha.projectstack.databinding.FragmentDeveloperHomeBinding

class DeveloperHomeFragment : Fragment() {
    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding: FragmentDeveloperHomeBinding
    private var list = java.util.ArrayList<TeamData>()
    private lateinit var adapter: TeamAdapter


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
        binding =FragmentDeveloperHomeBinding.inflate(inflater, container, false)

        setBatchAdapter(true)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab!!.position == 0) {
                    setBatchAdapter(true)
                } else {
                    setBatchAdapter(false)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.textView2.setOnClickListener {
            val addTaskBottomSheet = ApplytaskbsSheet()
            addTaskBottomSheet.show(activity.supportFragmentManager, "")
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setBatchAdapter(isTeam:Boolean) {
        adapter = TeamAdapter(list, activity)
        list.add(TeamData(1, "Batch 1", "01-01-2025", "28-02-2025", 20, isTeam))
        list.add(TeamData(1, "Batch 1", "01-01-2025", "28-02-2025", 20, isTeam))
        list.add(TeamData(1, "Batch 1", "01-01-2025", "28-02-2025", 20, isTeam))
        list.add(TeamData(1, "Batch 1", "01-01-2025", "28-02-2025", 20, isTeam))
        binding.batchListRV.layoutManager = LinearLayoutManager(context)
        binding.batchListRV.adapter = adapter
    }

    companion object {

    }
}
