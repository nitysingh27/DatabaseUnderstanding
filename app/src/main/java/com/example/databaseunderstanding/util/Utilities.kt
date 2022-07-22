package com.example.databaseunderstanding.util

import java.time.LocalDateTime

object Utilities {

    fun getCurrentDate() : String{
        val date = LocalDateTime.now()
        val day = date.dayOfMonth
        var month = date.monthValue.toString()
        if(month.length==1) {
            month = "0$month"
        }
        val year = date.year
        return "$year-$month-$day"
    }
}