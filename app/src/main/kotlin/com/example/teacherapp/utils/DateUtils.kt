package com.example.teacherapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    
    private const val DATE_FORMAT = "dd/MM/yyyy"
    private const val TIME_FORMAT = "HH:mm:ss"
    private const val FULL_FORMAT = "dd/MM/yyyy HH:mm:ss"

    fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    fun formatTime(timestamp: Long): String {
        val sdf = SimpleDateFormat(TIME_FORMAT, Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    fun formatFullDateTime(timestamp: Long): String {
        val sdf = SimpleDateFormat(FULL_FORMAT, Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    fun getCurrentDateTimestamp(): Long {
        return System.currentTimeMillis()
    }
}
