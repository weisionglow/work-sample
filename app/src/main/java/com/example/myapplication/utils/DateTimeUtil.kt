package com.example.myapplication.utils

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtil {

    fun convertToAnnouncement(dateString: String): String {

        return try {
//            val convertToDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ", Locale.ENGLISH)
            val convertToDate = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val date = convertToDate.parse(dateString)

            val month = SimpleDateFormat("MMM", Locale.ENGLISH).format(date!!)
            val day = SimpleDateFormat("dd", Locale.ENGLISH).format(date)

            "$day\n$month".toUpperCase()
        } catch (exception: Exception) {
            ""
        }
    }
}