package com.doan.mechacal.api

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @POST("/api/v1/auth/login")
    fun login(@Body request: LoginRequest): Call<AuthResponse>

    @POST("/api/v1/auth/register")
    fun register(@Body request: RegisterRequest): Call<AuthResponse>

    @GET("api/v1/user/info")
    fun getUserInfo(): Call<UserInfo>

    @Multipart
    @POST("/api/v1/user/update")
    fun updateUserInfo(
        @Part("userDto") userDto: RequestBody,
        @Part file: MultipartBody.Part?
    ): Call<UserInfo>
}