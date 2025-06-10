package com.saveetha.projectstack.util


data class LoginReqeust(val Username:String, val Password:String)

data class CreateStudentRequest(val username:String, val mail:String, val password:String,
    val mobile_number:Long, val register_number:String, val batch_year:Int, val mentor_number:Long,
    val mentor_name:String, val department:String, val date_of_joining:String)

data class CreateDeveloperRequest(val Bio_Id:Int,val Employee_Id:Int,val username:String,val mail:String,val Mobile_Number:Long,
                           val Designation:String,val Tech_Stack:String,val Experience:Int,val Linked_In:String,
    val Portfolio:String,val date_of_joining:String)