package com.saveetha.projectstack.util

data class LoginResponse(val message:String, val data:LoginData)
data class LoginData(val user_id:Int, val username:String,val role:String,val  regNo:String,
                     val Batchyear:Int,val mentorname:String,val mentorNo:Int,val departement:String,
                     val Bioid:Int,val employee:String,val designation:String,val TechStack:String,
                     val Experience:Int,val linkedIn:String,val protfile:String,val DateofJioning :Int)