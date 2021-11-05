package com.example.myapplication.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.utils.DialogUtil
import java.util.*

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val mainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
                lifecycleOwner = this@MainActivity
                viewModel = mainViewModel
            }

        mainViewModel.refreshEmployeeList()
        initViewModel()
    }

    private fun initViewModel() {
        mainViewModel.getEmployeeList.observe(this) {
            binding?.mainRecycleEmployee?.apply {
                adapter = EmployeeListAdapter(this@MainActivity, it.data)
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }

        mainViewModel.getErrorMsg.observe(this) {
            DialogUtil(this).show(message = it)
        }
    }
}