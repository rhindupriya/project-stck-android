package com.saveetha.projectstack.developer

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.saveetha.projectstack.databinding.ActivityTaskListBinding

class TaskListActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var binding: ActivityTaskListBinding
    private var list = ArrayList<TaskData>()
    private lateinit var adapter: TaskListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this

        // Set up the RecyclerView
        setBatchAdapter()

        // TabLayout listener

    }

    // Function to set up the RecyclerView adapter
    private fun setBatchAdapter() {
        // Sample data
        list.add(TaskData("123", "Rajkumar", "PMS", "Login Signup", "27/03/2024", "27/03/2024"))
        list.add(TaskData("124", "Suresh", "PMS", "UI Design", "28/03/2024", "28/03/2024"))

        // Set up the adapter
        adapter = TaskListAdapter(list, this)

        // Set the RecyclerView with the adapter
        binding.taskListRV.layoutManager = LinearLayoutManager(context)
        binding.taskListRV.adapter = adapter
    }
}
