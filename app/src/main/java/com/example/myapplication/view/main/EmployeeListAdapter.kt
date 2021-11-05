package com.example.myapplication.view.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.AdapterEmployeeBinding
import com.example.myapplication.model.EmployeeData

class EmployeeListAdapter(
    private val context: Context?,
    private val employeeList: List<EmployeeData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClick: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = (DataBindingUtil.inflate(
            inflater,
            R.layout.adapter_employee,
            parent,
            false
        ) as AdapterEmployeeBinding).root

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (context == null)
            return

        val binding = DataBindingUtil.getBinding<AdapterEmployeeBinding>(holder.itemView)
        binding?.response = employeeList[position]

        holder.itemView.setOnClickListener {
            onItemClick?.invoke()
        }
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}