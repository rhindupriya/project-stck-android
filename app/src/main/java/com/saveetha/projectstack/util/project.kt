package com.saveetha.projectstack.util

data class Project(
    val id: Int?,
    val title: String,
    val description: String,
    val user_id: Int,
    val developer_id: Int,
    val start_date: String,
    val end_date: String
)

