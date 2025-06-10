package com.saveetha.projectstack.developer


import java.util.ArrayList

class AttendanceData(val message:String, val data: ArrayList<Attendancelist>)

data class Attendancelist(val date:String, val registration_id:String, val status:String, val student_name:String,
    val id:Int)

data class AttendanceStudentData(val team_id:Int, val teamName:String, val students: ArrayList<Attendancelist>)

data class AttendanceListRequest(val team_id: Int)