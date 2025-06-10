package com.saveetha.projectstack.admin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saveetha.projectstack.R
import com.saveetha.projectstack.admin.response.TeamDataResponse
import com.saveetha.projectstack.admin.response.TeamListResponse
import com.saveetha.projectstack.databinding.FragmentCreateProjectBinding
import com.saveetha.projectstack.databinding.FragmentDeveloperListBinding
import com.saveetha.projectstack.databinding.FragmentProjectListBinding
import com.saveetha.projectstack.databinding.FragmentStudentlistBinding
import com.saveetha.projectstack.databinding.RvDeveloperListLayoutBinding
import com.saveetha.projectstack.databinding.RvStudentslistlayoutBinding
import com.saveetha.projectstack.databinding.RvTeamListLayoutBinding
import com.saveetha.projectstack.util.NetworkClient
import com.saveetha.projectstack.util.Static
import com.saveetha.projectstack.util.Student
import com.saveetha.projectstack.util.developerRespones
import com.saveetha.projectstack.util.developerlist
import com.saveetha.projectstack.util.studentlist
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeveloperListFragment : Fragment() {

    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding:FragmentDeveloperListBinding
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
        binding = FragmentDeveloperListBinding.inflate(inflater, container, false)
        binding.textView.setOnClickListener {
            Static.adminNavigate(activity, R.id.action_developerListFragment_to_createdeveloperFragment)
        }
        // Inflate the layout for this fragment
        binding.imageView6.setOnClickListener {
            Static.AdminBackStack(activity)
        }
        apiCall()
        return binding.root
    }

    private fun apiCall() {
        NetworkClient.api.Getdeveloper().enqueue(object:Callback<developerRespones> {
            override fun onResponse(
                call: Call<developerRespones>,
                response: Response<developerRespones>
            ) {
                if(response.isSuccessful) {

                    binding.developerlistRV.layoutManager = LinearLayoutManager(context)
                    binding.developerlistRV.adapter = DeveloperlistAdapterr(activity, response.body()!!.developers)
                } else {
                    val error = JSONObject(response.errorBody()!!.string())
                    try {
                        Toast.makeText(context, error.getString("message") , Toast.LENGTH_SHORT).show()
                    }catch (e:Exception) {
                        Toast.makeText(context, "response Error :"+ e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<developerRespones>, t: Throwable) {
                t.message?.let { Log.e("developerListFragment", t.message!!) }
                Toast.makeText(context, "onfailure :"+ t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    class DeveloperlistAdapterr(val activity: FragmentActivity, private val list:ArrayList<developerlist>)
        : RecyclerView.Adapter<DeveloperlistAdapterr.MyViewHolder>() {

        class MyViewHolder(val binding: RvDeveloperListLayoutBinding): RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(RvDeveloperListLayoutBinding.inflate(activity.layoutInflater, parent, false))
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val data = list[position]
            holder.binding.bioIdTv.text = ""+data.Bio_id
            holder.binding.NameTV.text = ""+data.name
            holder.binding.officialEmailTV.text = ""+data.email
            holder.binding.mobileNoTV.text = ""+data.mobile_number
            holder.binding.dateOfJoiningTV.text = ""+data.date_of_joining
        }

    }

}

