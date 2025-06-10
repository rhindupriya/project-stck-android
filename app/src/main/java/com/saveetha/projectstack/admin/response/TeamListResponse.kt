package com.saveetha.projectstack.admin.response

data class TeamListResponse (val message:String, val data:java.util.ArrayList<TeamDataResponse>)

data class TeamDataResponse(val developer_id:Int, val end_date:String, val start_date:String,
    val student1:Int, val student2:Int, val student3:Int, val team_id:Int, val team_name:String)


data class CommonResponse(val message:String)