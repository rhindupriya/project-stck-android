package com.saveetha.projectstack

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.saveetha.projectstack.admin.AdminDashBoardActivity
import com.saveetha.projectstack.databinding.ActivityLoginBinding
import com.saveetha.projectstack.developer.DeveloperDashBoardActivity
import com.saveetha.projectstack.user.UserDashboardActivity
import com.saveetha.projectstack.util.LoginReqeust
import com.saveetha.projectstack.util.LoginResponse
import com.saveetha.projectstack.util.NetworkClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

        private lateinit var binding:ActivityLoginBinding
        private lateinit var sharedPreferences: SharedPreferences
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)

            sharedPreferences = getSharedPreferences("LOGIN", Context.MODE_PRIVATE)

            if(sharedPreferences.getString("userName", null)!=null) {
                if(sharedPreferences.getString("userType", "")?.uppercase().equals("ADMIN")) {
                    val intent = Intent(this@LoginActivity, AdminDashBoardActivity::class.java)
                    startActivity(intent)
                } else if(sharedPreferences.getString("userType", "")?.uppercase().equals("STUDENT")) {
                    val intent = Intent(this@LoginActivity, UserDashboardActivity::class.java)
                    startActivity(intent)
                }else if(sharedPreferences.getString("userType", "")?.uppercase().equals("DEVELOPER")) {
                    val intent = Intent(this@LoginActivity, DeveloperDashBoardActivity::class.java)
                    startActivity(intent)
                }
                finish()
                return
            }

            binding.btnLogin.setOnClickListener {

                val email = binding.email.text.toString()
                val password = binding.password.text.toString()

                if(email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this@LoginActivity, "Fill All the Fields", Toast.LENGTH_LONG).show()
                } else {
                    apiCall(email, password)
                }

            }

        }

    private fun apiCall(username:String , password:String) {
        NetworkClient.api.login(LoginReqeust(username, password)).enqueue(object: Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                if(response.isSuccessful) {
                    val editor:SharedPreferences.Editor  = sharedPreferences.edit()
                    editor.putInt("userId", response.body()!!.data.user_id)
                    editor.putString("userName", response.body()!!.data.username)
                    editor.putInt("bioId", response.body()!!.data.Bioid)
                    editor.putString("regNo", response.body()!!.data.regNo)
                    editor.putString("profile", response.body()!!.data.protfile)
                    editor.putString("userType", response.body()!!.data.role)
                    editor.apply()
                    Toast.makeText(this@LoginActivity, response.body()?.message, Toast.LENGTH_LONG).show();
                    if(response.body()?.data?.role?.uppercase().equals("ADMIN")) {
                        val intent = Intent(this@LoginActivity, AdminDashBoardActivity::class.java)
                        startActivity(intent)
                    } else if(response.body()?.data?.role?.uppercase().equals("STUDENT")) {
                        val intent = Intent(this@LoginActivity, UserDashboardActivity::class.java)
                        startActivity(intent)
                    }else if(response.body()?.data?.role?.uppercase().equals("DEVELOPER")) {
                        val intent = Intent(this@LoginActivity, DeveloperDashBoardActivity::class.java)
                        startActivity(intent)
                    }
                    Toast.makeText(this@LoginActivity, response.body()?.message, Toast.LENGTH_LONG).show();
                } else {
                    try {
                        val jsonObject = JSONObject(response.errorBody()?.string())
                        Toast.makeText(this@LoginActivity, jsonObject.getString("error"), Toast.LENGTH_LONG).show();
                    } catch (e:Exception) {
                        Toast.makeText(this@LoginActivity, e.message, Toast.LENGTH_LONG).show();
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "error "+t.message, Toast.LENGTH_LONG).show();
            }

        })
    }
}