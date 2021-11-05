package com.example.myapplication.binding

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.R

@BindingAdapter("imageUrlBind")
fun setImageUrlBind(image: ImageView, url: String?) {
    if (url != null) {
        Glide.with(image.context).load(url).placeholder(R.drawable.ic_launcher_foreground)
            .into(image)
    }
}