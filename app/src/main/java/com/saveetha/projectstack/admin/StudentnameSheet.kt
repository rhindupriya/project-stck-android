package com.saveetha.projectstack.admin

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.saveetha.projectstack.databinding.BsStudentListBinding
import com.saveetha.projectstack.util.NetworkClient
import com.saveetha.projectstack.util.studentsRespones
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentNameSheet : BottomSheetDialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val view = LayoutInflater.from(context).inflate(
            com.saveetha.projectstack.R.layout.bs_student_list, null
        )
        val binding = BsStudentListBinding.bind(view)
        dialog.setContentView(binding.root)

        binding.progress.visibility = View.INVISIBLE
        NetworkClient.api.StudentNameSheet().enqueue(object : Callback<studentsRespones> {

            override fun onResponse(
                call: Call<studentsRespones>,
                response: Response<studentsRespones>
            ) {
                binding.progress.visibility = View.INVISIBLE
                if(response.isSuccessful) {
                    val data = response.body()!!.students
                    val adapter = StudentListAdapter(data, activity!!)
                    binding.studentlistRV.adapter = adapter
                    val selectedTeamIds = ArrayList<Int>()
                    binding.createTeamB.setOnClickListener {
                        selectedTeamIds.clear()
                        data.forEach { stdData->

                        }
                    }
                } else {
                    Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<studentsRespones>, t: Throwable) {
                binding.progress.visibility = View.INVISIBLE
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
        return dialog
    }

}
