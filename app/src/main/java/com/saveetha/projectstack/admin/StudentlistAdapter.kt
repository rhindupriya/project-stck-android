package com.saveetha.projectstack.admin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.projectstack.databinding.RvStudentnameBinding
import com.saveetha.projectstack.util.studentdata

class StudentListAdapter(val list:ArrayList<studentdata>, val activity:FragmentActivity): RecyclerView.Adapter<StudentListAdapter.MyViewHolder>(){

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
        holder.binding.studentRegNo.text = "RegNo" + data.reg_no
        holder.binding.studentName.text = "Name" + data.name
//        holder.binding.studentDepartment.text = "Department" + data.department
        holder.binding.studentEmail.text = "Email" + data.email
//        holder.binding.studentMobile.text = "Mobile" + data.mobile_number
//        holder.binding.studentBatch.text = "Batch" + data.batch_year

    }

}
