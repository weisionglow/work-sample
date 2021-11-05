package com.example.myapplication

import android.app.Application
import com.example.myapplication.server.RetrofitServer

class MyMainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        RetrofitServer.refreshRetrofitServer(this)
    }
}