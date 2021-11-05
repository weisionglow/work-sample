package com.example.myapplication.server

import com.example.myapplication.model.*
import com.example.myapplication.model.response.EmployeeResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("employees")
    suspend fun employeeList(): Response<EmployeeResponse>
}