package com.saveetha.projectstack.util

import java.util.ArrayList


data class studentlist( val status:String,val students:ArrayList<Student>)


data class Student(val id: Int, val reg_no: String, val email: String, val mobile_number: String,
    val department: String, val name: String, val batch_year: String)
