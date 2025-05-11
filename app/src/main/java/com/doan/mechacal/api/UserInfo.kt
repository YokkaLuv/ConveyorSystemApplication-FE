package com.doan.mechacal.api

data class UserInfo(
    val userId: String,
    var name: String,
    var phoneNumber: String?,
    var imageUrl: String?,
    val email: String,
    var role: String,
    var sessionIds: List<String>? = null
)

