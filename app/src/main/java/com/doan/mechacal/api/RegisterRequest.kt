package com.doan.mechacal.api

class RegisterRequest(
    var name: String,
    private val email: String,
    private val username: String,
    private val password: String
)
