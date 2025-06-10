package com.saveetha.projectstack.admin

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.saveetha.projectstack.R
import com.saveetha.projectstack.admin.response.CommonResponse
import com.saveetha.projectstack.databinding.FragmentCreatedeveloperBinding
import com.saveetha.projectstack.util.CreateDeveloperRequest
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

class CreatedeveloperFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var activity: FragmentActivity
    private lateinit var context: Context
    private lateinit var binding: FragmentCreatedeveloperBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreatedeveloperBinding.inflate(inflater, container, false)

        try {
            context = requireContext()
            activity = requireActivity()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        binding.etDateOfJoining.setOnClickListener {
             showDatePickerDialog()
        }

        binding.btnSubmit.setOnClickListener {
            val Bio_Id = binding.etBioID.text.toString()
            val Employee_Id = binding.etEmployeeID.text.toString()
            val username= binding.etName.text.toString()
            val mail = binding.etPersonalEmail.text.toString()
            val Mobile_Number = binding.etMobileNumber.text.toString()
            val Designation = binding.etDesignation.text.toString()
            val Tech_Stack = binding.etTechStack.text.toString()
            val Experience = binding.etExperience.text.toString()
            val Linked_In =binding.etLinkedIn.text.toString()
            val Portfolio = binding.etPortfolio.text.toString()
            val date_of_joining = binding.etDateOfJoining.text.toString()
            if (Bio_Id.isEmpty() || Employee_Id.isEmpty() ||  username.isEmpty() || mail.isEmpty() || Mobile_Number.isEmpty()|| Designation.isEmpty() || Tech_Stack.isEmpty() || Experience.isEmpty() || Linked_In.isEmpty() || Portfolio.isEmpty() || date_of_joining.isEmpty()){
                Toast.makeText(context, "Fill All Fields", Toast.LENGTH_LONG).show()
            } else {
                createApi(
                    Bio_id = Bio_Id.toInt(),
                    Employee_Id = Employee_Id.toInt(),
                    username = username,
                    mail = mail,
                    Mobile_Number = Mobile_Number.toLong(),
                    Designation = Designation,
                    Tech_Stack = Tech_Stack,
                    Experience =Experience.toInt(),
                    Linked_In = Linked_In,
                    Portfolio = Portfolio,
                    date_of_joining = date_of_joining
                )
            }
        }

        binding.btnSubmit.setOnClickListener {
            Static.AdminBackStack(activity)
        }

        binding.btnCancel.setOnClickListener {
            Static.AdminBackStack(activity)
        }
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
        Bio_id :Int, Employee_Id : Int,username : String,mail: String,Mobile_Number:Long,Designation:String,Tech_Stack: String,
        Experience :Int,Linked_In:String,Portfolio:String,date_of_joining:String
    ){

        val reqeust = CreateDeveloperRequest(
            Bio_Id = Bio_id,
            Employee_Id = Employee_Id,
            username = username,
            mail = mail,
            Mobile_Number = Mobile_Number.toLong(),
            Designation = Designation,
            Tech_Stack = Tech_Stack,
            Experience =Experience,
            Linked_In = Linked_In,
            Portfolio = Portfolio,
            date_of_joining =date_of_joining
        )

        NetworkClient.api.CreateDeveloper(reqeust).enqueue(object : Callback<CommonResponse> {
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


