package com.example.myapplication.utils

import android.content.Context
import android.content.SharedPreferences

object CacheUtil {

    private const val MY_APPLICATION_CACHE = "MY_APPLICATION_CACHE"
    private const val USER_ACCESS_TOKEN = "USER_ACCESS_TOKEN"

    private fun getSharedPref(context: Context?): SharedPreferences? {
        if (context == null) {
            return null
        }

        return context.getSharedPreferences(MY_APPLICATION_CACHE, Context.MODE_PRIVATE)
    }

    private fun save(context: Context?, key: String?, value: Any?) {
        val sharedPref = getSharedPref(context)


        if (sharedPref == null || key == null) {
            return
        }

        val editor = sharedPref.edit()
        when (value) {
            is String -> editor.putString(key, value)
            is Long -> editor.putLong(key, value)
            is Int -> editor.putInt(key, value)
            is Boolean -> editor.putBoolean(key, value)
        }

        editor.apply()
    }

    private fun remove(context: Context?, key: String?) {
        val sharedPref = getSharedPref(context)

        if (sharedPref == null || key == null) {
            return
        }
        val editor = sharedPref.edit()
        editor.remove(key)
        editor.apply()
    }

    fun saveAccessToken(context: Context?, accessToken: String?) {
        save(context, USER_ACCESS_TOKEN, accessToken)
    }

    fun getAccessToken(context: Context?): String? {
        return getSharedPref(context)?.getString(USER_ACCESS_TOKEN, "")
    }
}