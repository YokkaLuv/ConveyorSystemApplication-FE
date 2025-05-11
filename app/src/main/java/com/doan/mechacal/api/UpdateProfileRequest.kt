package com.doan.mechacal.api

data class UpdateProfileRequest(
    val userId: String,
    val name: String?,
    val phoneNumber: String?,
    val imageUrl: String?,
    val email: String?,
    val role: String?,
    val sessionIds: List<String>?
)
