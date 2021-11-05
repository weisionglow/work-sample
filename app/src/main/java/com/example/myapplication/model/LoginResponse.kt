package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val access_token: String,
    val expires_in: Int,
    val refresh_token: String,
    val token_type: String,

    @SerializedName("error")
    val error: String? = null
)