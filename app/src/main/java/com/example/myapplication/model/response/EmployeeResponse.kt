package com.example.myapplication.model.response


import com.example.myapplication.model.EmployeeData
import com.google.gson.annotations.SerializedName

data class EmployeeResponse(
    @SerializedName("data")
    val `data`: List<EmployeeData>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)