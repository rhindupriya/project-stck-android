package com.saveetha.projectstack.developer

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.projectstack.databinding.RvProjectlistlayoutBinding
class ProjectAdapter(private val list: List<ProjectData>, private val activity: FragmentActivity) :
    RecyclerView.Adapter<ProjectAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: RvProjectlistlayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvProjectlistlayoutBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]

        // Safely binding data to the UI components
//        holder.binding.titleTV.text = data.title
//        holder.binding.studentIdTV.text = data.studentId
//        holder.binding.studendNameTV.text = data.studentName
//        holder.binding.StartDateTV.text = data.startDate
//        holder.binding.endDateTV.text = data.endDate
//        holder.binding.developerTV.text = data.developer
//        holder.binding.projectDescriptionTV.text = data.projectDescription
//        // Handling click events correctly
//        holder.binding.root.setOnClickListener {
//            val intent = Intent(activity, ProjectAdapterActivity::class.java)
//            activity.startActivity(intent)
//        }
    }
}
