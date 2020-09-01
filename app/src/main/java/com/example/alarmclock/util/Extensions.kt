package com.example.alarmclock.util

import android.content.Context
import android.widget.Toast
import java.util.*

fun correctTime(hourOfDay: Int, minuteOfDay: Int): String =
    "${hourOfDay.add0IfNeeded()}:${minuteOfDay.add0IfNeeded()}"

fun Int.add0IfNeeded(): String {
    var newNumber = this.toString()
    if (this < 10) newNumber = "0$this"
    return newNumber
}

fun String.splitting(): List<String> = this.split(":")

fun reqCode(): Int = (0..1000).random()

fun calendar(): Calendar = Calendar.getInstance()

fun getAlarmCalendar(hourOfDay: Int, minute: Int): Long {
    val cal = calendar()

    cal[Calendar.HOUR_OF_DAY] = hourOfDay
    cal[Calendar.MINUTE] = minute
    cal[Calendar.SECOND] = 0
    cal[Calendar.MILLISECOND] = 0

    return cal.timeInMillis
}

fun toast(context: Context, title: String) =
    Toast.makeText(context, title, Toast.LENGTH_LONG).show()
