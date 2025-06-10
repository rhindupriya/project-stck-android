package com.saveetha.projectstack.util

import com.saveetha.projectstack.admin.response.CommonResponse
import com.saveetha.projectstack.admin.response.TeamListResponse
import com.saveetha.projectstack.developer.AttendanceData
import com.saveetha.projectstack.developer.AttendanceListRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Service {

    @POST("login")
    fun login(@Body reqeust: LoginReqeust): Call<LoginResponse>

    @GET("read_teams")
    fun getTeamList() :Call<TeamListResponse>

    @POST("create_student")
    fun createStudent(@Body request: CreateStudentRequest) : Call<CommonResponse>

    @POST("create_developer")
    fun CreateDeveloper(@Body request: CreateDeveloperRequest)   :   Call<CommonResponse>

    @GET("api/students")
    fun Getstudent() : Call<studentlist>
    @GET("api/developers")
    fun  Getdeveloper() : Call<developerRespones>

    @POST("get_attendentance_by_team_id")
    fun  attendentance(@Body request:AttendanceListRequest) : Call<AttendanceData>


    @GET("api/students")
    fun StudentNameSheet() : Call<studentsRespones>
}