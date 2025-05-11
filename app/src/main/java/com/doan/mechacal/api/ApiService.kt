package com.doan.mechacal.api

import com.doan.mechacal.api.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/api/v1/auth/login")
    fun login(@Body request: LoginRequest): Call<AuthResponse>

    @POST("/api/v1/auth/register")
    fun register(@Body request: RegisterRequest): Call<AuthResponse>
}
