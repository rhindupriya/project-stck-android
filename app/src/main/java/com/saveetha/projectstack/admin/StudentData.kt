package com.saveetha.projectstack.admin

data class StudentData(val status :String,val Student:StudentDataSheet)
data class StudentDataSheet(val batch_year:String,val department:String,val email:String,val id:String,val mobile_number:String,
        val name:String,val reg_no:String)

