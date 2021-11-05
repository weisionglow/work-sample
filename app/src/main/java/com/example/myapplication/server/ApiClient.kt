package com.example.myapplication.server

import com.example.myapplication.model.response.EmployeeResponse
import retrofit2.Response

class ApiClient(private val apiInterface: ApiInterface) {

    suspend fun getEmployeeList(): Response<EmployeeResponse> {
        return apiInterface.employeeList()
    }
}