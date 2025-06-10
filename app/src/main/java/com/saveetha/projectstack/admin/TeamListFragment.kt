package com.saveetha.projectstack.admin

import android.content.Context
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
import com.saveetha.projectstack.admin.response.TeamDataResponse
import com.saveetha.projectstack.admin.response.TeamListResponse
import com.saveetha.projectstack.databinding.FragmentTeamListBinding
import com.saveetha.projectstack.databinding.RvTeamListLayoutBinding
import com.saveetha.projectstack.util.NetworkClient
import com.saveetha.projectstack.util.Static
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamListFragment : Fragment() {

    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding: FragmentTeamListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        try {
            context = requireContext()
            activity = requireActivity()
        } catch (e:Exception) {
            e.printStackTrace()
        }
        binding = FragmentTeamListBinding.inflate(inflater, container, false)

        binding.imageView6.setOnClickListener {
            Static.AdminBackStack(activity)
        }

        binding.textView.setOnClickListener {
            val teamName = binding.teamNameTV.text.toString()
            if(teamName.isEmpty()) {
                Toast.makeText(context, "Enter Team Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
           val addStudentNameSheet = StudentNameSheet()
           addStudentNameSheet.show(activity.supportFragmentManager, "")
        }
        apiCall()

        return binding.root
    }

    private fun apiCall() {
        NetworkClient.api.getTeamList().enqueue(object: Callback<TeamListResponse> {
            override fun onResponse(
                call: Call<TeamListResponse>,
                response: Response<TeamListResponse>
            ) {
              if(response.isSuccessful) {

                  binding.teamListRV.layoutManager = LinearLayoutManager(context)
                  binding.teamListRV.adapter = TeamListAdapter(activity, response.body()!!.data)
              } else {
                  val error = JSONObject(response.errorBody()!!.string())
                  try {
                      Toast.makeText(context, error.getString("message") , Toast.LENGTH_SHORT).show()
                  }catch (e:Exception) {
                      Toast.makeText(context, "response Error :"+ e.message, Toast.LENGTH_SHORT).show()
                  }
              }
            }

            override fun onFailure(call: Call<TeamListResponse>, t: Throwable) {
                t.message?.let { Log.e("TeamListFragment", it) }
                Toast.makeText(context, "onfailure :"+ t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    class TeamListAdapter(val activity: FragmentActivity, private val list:ArrayList<TeamDataResponse>)
        :RecyclerView.Adapter<TeamListAdapter.MyViewHolder>() {

        class MyViewHolder(val binding:RvTeamListLayoutBinding):RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(RvTeamListLayoutBinding.inflate(activity.layoutInflater, parent, false))
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.binding.teamNameTV.text = list[position].team_name
        }

    }

}