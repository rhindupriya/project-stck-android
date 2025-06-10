package com.saveetha.projectstack.developer

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.saveetha.projectstack.databinding.ActivityAttendanceBinding
import com.saveetha.projectstack.util.NetworkClient
import com.saveetha.projectstack.util.Static
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AttendanceActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var binding: ActivityAttendanceBinding
    private var list = ArrayList<Attendancelist>()
    private lateinit var adapter: AttendanceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAttendanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this

        list = ArrayList()
        adapter = AttendanceAdapter(list, this)

        binding.attendanceRV.layoutManager = LinearLayoutManager(this)
        binding.attendanceRV.adapter = adapter


        if(intent!=null)
        {
            val teamId = intent.getIntExtra("TeamId", 0)
            getAttendanceList(teamId)
        }
        binding.imageView6.setOnClickListener {
             finish()
        }
//        apiCall()
//        return binding.root

    }

    private fun getAttendanceList(teamId:Int) {
        NetworkClient.api.attendentance(AttendanceListRequest(teamId)).enqueue(object:Callback<AttendanceData>{
            override fun onResponse(
                call: Call<AttendanceData>,
                response: Response<AttendanceData>
            ) {
                if(response.isSuccessful) {
                    list.addAll(response.body()!!.data)
                    adapter.notifyDataSetChanged()
                } else {
                    try {
                        val jsonObject = JSONObject(response.errorBody()?.string())
                        Toast.makeText(this@AttendanceActivity, jsonObject.getString("error"), Toast.LENGTH_LONG).show();
                    } catch (e:Exception) {
                        Toast.makeText(this@AttendanceActivity, e.message, Toast.LENGTH_LONG).show();
                    }
                }
            }

            override fun onFailure(call: Call<AttendanceData>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
