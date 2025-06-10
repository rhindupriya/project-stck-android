package com.saveetha.projectstack.developer

import android.content.Intent
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.projectstack.databinding.RvMarkAttendanceLayoutBinding

class AttendanceAdapter(val list: List<Attendancelist>, val activity: FragmentActivity)
    : RecyclerView.Adapter<AttendanceAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: RvMarkAttendanceLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RvMarkAttendanceLayoutBinding.inflate(activity.layoutInflater, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]

        // Binding data to views
        holder.binding.regNoTV.text = "Register No: ${data.registration_id}"
        holder.binding.studentNameTV.text = "Student Name: ${data.student_name}"
        holder.binding.taskDateTV.text="taskDate:${data.date}"
        holder.binding.statusTV.text="status:${data.status}"
        val attendanceCheckBox = holder.binding.etcheckPresent
        attendanceCheckBox.isChecked = false
        attendanceCheckBox.setOnCheckedChangeListener { _, isChecked ->
            // Update the attendance status
            //data.isPresent = isChecked
        }

        // Set onClickListener to open TaskListActivity (optional)
        holder.binding.root.setOnClickListener {
            val intent = Intent(activity, TaskListActivity::class.java)
//            intent.putExtra("TeamId", data.)  // Replace 123 with your integer value
            activity.startActivity(intent)

        }



    }
}
