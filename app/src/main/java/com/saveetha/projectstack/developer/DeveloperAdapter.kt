package com.saveetha.projectstack.developer

import android.content.Intent
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.projectstack.databinding.RvBatchListLayoutBinding
import com.saveetha.projectstack.databinding.RvDeveloperListLayoutBinding
import com.saveetha.projectstack.util.developerlist

class DeveloperAdapter(val list:List<developerlist>, val activity:FragmentActivity): RecyclerView.Adapter<DeveloperAdapter.MyViewHolder>(){

    class MyViewHolder(val binding:RvDeveloperListLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RvDeveloperListLayoutBinding.inflate(activity.layoutInflater, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.binding.bioIdTv.text = ""+data.Bio_id
        holder.binding.NameTV.text = ""+data.name
        holder.binding.officialEmailTV.text = ""+data.email
        holder.binding.mobileNoTV.text = ""+data.mobile_number
        holder.binding.dateOfJoiningTV.text = ""+data.date_of_joining
        holder.binding.root.setOnClickListener {
            var intent:Intent
//            if(data.isTeam) {
//                intent = Intent(activity, TaskListActivity::class.java)
//            } else {
//                intent = Intent(activity, AttendanceActivity::class.java)
//            }
//            activity.startActivity(intent)
        }
    }
}
