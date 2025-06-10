package com.saveetha.projectstack.developer

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.projectstack.admin.StudentDataSheet
import com.saveetha.projectstack.databinding.RvStudentListBinding
import com.saveetha.projectstack.databinding.RvStudentnameBinding
import com.saveetha.projectstack.databinding.RvStudentslistlayoutBinding
import com.saveetha.projectstack.databinding.RvTaskListLayoutBinding
import com.saveetha.projectstack.util.Student

class StudentAdapter(val list:List<StudentDataSheet>, val activity:FragmentActivity)
    : RecyclerView.Adapter<StudentAdapter.MyViewHolder>(){


    class MyViewHolder(val binding: RvStudentnameBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvStudentnameBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]

        // Binding data to the UI components
//        holder.binding.student_reg_no.text = "RegNo"
//        holder.binding.studentName.text = "Name"
//        holder.binding.studentEmail.text = "Email"

        holder.binding.studentName.text = data.name
        holder.binding.studentEmail.text= data.email
        holder.binding.studentRegNo.text= data.reg_no

    }

}
