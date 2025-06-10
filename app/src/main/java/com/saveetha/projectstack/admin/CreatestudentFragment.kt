package com.saveetha.projectstack.admin

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.saveetha.projectstack.R
import com.saveetha.projectstack.admin.response.CommonResponse
import com.saveetha.projectstack.databinding.FragmentCreatestudentBinding
import com.saveetha.projectstack.util.CreateStudentRequest
import com.saveetha.projectstack.util.NetworkClient
import com.saveetha.projectstack.util.Static
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CreatestudentFragment : Fragment() {

    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding: FragmentCreatestudentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCreatestudentBinding.inflate(inflater, container, false)

        try {
            context = requireContext()
            activity = requireActivity()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        binding.etDateOfJoining.setOnClickListener {
            showDatePickerDialog()
        }

        binding.tvSubmit.setOnClickListener {
            val regNo:String = binding.etregNo.text.toString()
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val mobileNo = binding.etMobileNumber.text.toString()
            val depmt = binding.etdepartment.text.toString()
            val batchYear = binding.etbatchYear.text.toString()
            val mentorName = binding.mentorName.text.toString()
            val mentorMobile = binding.mentorNumber.text.toString()
            val dateOfJoining = binding.etDateOfJoining.text.toString()
            if (regNo.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty() || mobileNo.isEmpty() || depmt.isEmpty() || batchYear.isEmpty() || mentorName.isEmpty() || mentorMobile.isEmpty() || dateOfJoining.isEmpty()) {
                Toast.makeText(context, "Fill All Fields", Toast.LENGTH_LONG).show()
            } else {
                createApi(
                    regNo = regNo,
                    name = name,
                    email = email,
                    password = password,
                    mobileNo = mobileNo.toLong(),
                    depmt = depmt,
                    batchYear = batchYear.toInt(),
                    mentorName = mentorName,
                    mentorMobile = mentorMobile.toLong(),
                    dateOfJoining = dateOfJoining
                )
            }
        }
        binding.tvSubmit.setOnClickListener {
            Static.AdminBackStack(activity)
        }
        binding.cancelButton.setOnClickListener {
            Static.AdminBackStack(activity)
        }

        // Inflate the layout for this fragment
        return binding.root
    }



private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog =
            DatePickerDialog(context, { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(selectedYear, selectedMonth, selectedDay)

                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)

                binding.etDateOfJoining.text = ""+selectedYear+"-"+(1+selectedMonth)+"-"+selectedDay
            }, year, month, day)

        datePickerDialog.show()
    }

    fun createApi(
        regNo: String, name: String, email: String, password: String, mobileNo: Long,
        depmt: String, batchYear: Int, mentorName: String,
        mentorMobile: Long, dateOfJoining: String
    ) {
        val reqeust = CreateStudentRequest(
            username = name,
            mail = email,
            password = password,
            mobile_number = mobileNo,
            register_number = regNo,
            batch_year = batchYear,
            mentor_number = mentorMobile,
            mentor_name = mentorName,
            department = depmt,
            date_of_joining = dateOfJoining
        )
        NetworkClient.api.createStudent(reqeust).enqueue(object : Callback<CommonResponse> {
            override fun onResponse(
                call: Call<CommonResponse>,
                response: Response<CommonResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(context, response.body()!!.message, Toast.LENGTH_LONG).show()
                } else {
                    try {
                        val jsonObject = JSONObject(response.errorBody()?.string())
                        Toast.makeText(context, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (e:Exception) {
                        Toast.makeText(context, e.message, Toast.LENGTH_LONG).show();
                    }
                }
            }

            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }


        })
    }

    }
