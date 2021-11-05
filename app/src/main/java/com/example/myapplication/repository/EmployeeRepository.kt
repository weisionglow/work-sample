package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.ApiResult
import com.example.myapplication.model.response.EmployeeResponse
import com.example.myapplication.server.RetrofitServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmployeeRepository {

    private val employeeList = MutableLiveData<EmployeeResponse>()
    val getEmployeeList: LiveData<EmployeeResponse> get() = employeeList

    private val errorMsg = MutableLiveData<String>()
    val getErrorMsg: LiveData<String> get() = errorMsg

    suspend fun getEmployeeList() {
        val request = RetrofitServer.getInstance()?.getEmployeeList()

        if (request?.isSuccessful == true) {
            employeeList.value = request.body()
        } else {
            errorMsg.value = "Something went wrong"
        }
    }
}