package com.saveetha.projectstack.developer

import android.content.Intent
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.projectstack.databinding.RvBatchListLayoutBinding

class TeamAdapter(val list:List<TeamData>, val activity:FragmentActivity): RecyclerView.Adapter<TeamAdapter.MyViewHolder>(){

    class MyViewHolder(val binding:RvBatchListLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RvBatchListLayoutBinding.inflate(activity.layoutInflater, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]
        holder.binding.teamCountTV.text = ""+data.studentCount
        holder.binding.batchNameTV.text = data.batch
        holder.binding.fromAndToDateTV.text = data.startDate +" - "+ data.endDate

        holder.binding.root.setOnClickListener {
            var intent:Intent
            if(data.isTeam) {
                intent = Intent(activity, AttendanceActivity::class.java)
            } else {
                intent = Intent(activity, AttendanceActivity::class.java)

            }
//            activity.startActivity(intent)
            intent = Intent(activity, AttendanceActivity::class.java)
            intent.putExtra("TeamId", data.batchId)  // Replace 123 with your integer value
            activity.startActivity(intent)
        }
    }
}