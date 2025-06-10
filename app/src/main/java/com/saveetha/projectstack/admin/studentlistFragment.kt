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
import com.saveetha.projectstack.databinding.FragmentProjectListBinding
import com.saveetha.projectstack.databinding.FragmentStudentlistBinding
import com.saveetha.projectstack.databinding.RvStudentslistlayoutBinding
import com.saveetha.projectstack.databinding.RvTeamListLayoutBinding
import com.saveetha.projectstack.util.NetworkClient
import com.saveetha.projectstack.util.Static
import com.saveetha.projectstack.util.Student
import com.saveetha.projectstack.util.studentlist
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class studentlistFragment : Fragment() {

    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding:FragmentStudentlistBinding
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
        binding = FragmentStudentlistBinding.inflate(inflater, container, false)
        binding.textView.setOnClickListener {
            Static.adminNavigate(activity, R.id.action_studentlistFragment_to_createstudentFragment2)
        }
        binding.imageView6.setOnClickListener {
            Static.AdminBackStack(activity)
        }
        apiCall()
        return binding.root
     }

    private fun apiCall() {
        NetworkClient.api.Getstudent().enqueue(object: Callback<studentlist> {
            override fun onResponse(
                call: Call<studentlist>,
                response: Response<studentlist>
            ) {
                if(response.isSuccessful) {

                    binding.studentlistRV.layoutManager = LinearLayoutManager(context)
                    binding.studentlistRV.adapter = StudentListAdapter(activity, response.body()!!.students)
                } else {
                    val error = JSONObject(response.errorBody()!!.string())
                    try {
                        Toast.makeText(context, error.getString("message") , Toast.LENGTH_SHORT).show()
                    }catch (e:Exception) {
                        Toast.makeText(context, "response Error :"+ e.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<studentlist>, t: Throwable) {
                t.message?.let { Log.e("StudentListFragment", t.message!!) }
                Toast.makeText(context, "onfailure :"+ t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    class StudentListAdapter(val activity: FragmentActivity, private val list:ArrayList<Student>)
        : RecyclerView.Adapter<StudentListAdapter.MyViewHolder>() {

        class MyViewHolder(val binding: RvStudentslistlayoutBinding): RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(RvStudentslistlayoutBinding.inflate(activity.layoutInflater, parent, false))
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        }

    }

}

