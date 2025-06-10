package com.saveetha.projectstack.util

import java.util.ArrayList

class developerRespones(val status:String,val developers: ArrayList<developerlist>)

data class developerlist(val Bio_id: Int, val name: String, val email: String, val mobile_number: String,
                       val date_of_joining: String)

