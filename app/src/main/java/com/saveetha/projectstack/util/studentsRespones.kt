package com.saveetha.projectstack.util

data class studentsRespones(val status:String, val students:ArrayList<studentdata>)
data class studentdata( val batch_year:String,val department:String,val email:String,val id:String,
    val  mobile_number:String,val name:String,val reg_no:String)
