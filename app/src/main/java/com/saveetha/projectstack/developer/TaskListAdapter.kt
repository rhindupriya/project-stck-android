package com.saveetha.projectstack.developer

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.projectstack.databinding.RvTaskListLayoutBinding

class TaskListAdapter(val list:List<TaskData>, val activity:FragmentActivity): RecyclerView.Adapter<TaskListAdapter.MyViewHolder>(){


    class MyViewHolder(val binding: RvTaskListLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvTaskListLayoutBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]

        // Binding data to the UI components
        holder.binding.numberTV.text = "" + data.regisrationId
        holder.binding.studentNameTV.text = "" + data.studentName
        holder.binding.titleTV.text = "" + data.title
        holder.binding.taskNameTV.text = "" + data.taskName
        holder.binding.taskDateTV.text = ""+data.taskDate
        holder.binding.endDateTV.text = ""+data.endDate



    }

}
