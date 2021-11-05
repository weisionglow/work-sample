package com.example.myapplication.view.main

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.ApiResult
import com.example.myapplication.model.response.EmployeeResponse
import com.example.myapplication.repository.EmployeeRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel : ViewModel(), Observable {

    private val repository = EmployeeRepository()
    val getEmployeeList get() = repository.getEmployeeList
    val getErrorMsg get() = repository.getErrorMsg

    @Bindable
    val editText = MutableLiveData<String>()

    fun refreshEmployeeList() {
        viewModelScope.launch {
            repository.getEmployeeList()
        }
    }

    fun clickButton() {
        val value = editText.value ?: ""

        Log.d("###", value)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}