package com.example.myapplication.model

import com.example.myapplication.repository.EmployeeRepository

sealed class ApiResult<out R> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
}
