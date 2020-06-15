package com.example.alarmclock.util

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

fun getAlarmCalendar(hourOfDay: Int, minute: Int): Long {
    val calNow = Calendar.getInstance()
    val calSet = calNow.clone() as Calendar

    calSet[Calendar.HOUR_OF_DAY] = hourOfDay
    calSet[Calendar.MINUTE] = minute
    calSet[Calendar.SECOND] = 0
    calSet[Calendar.MILLISECOND] = 0

    if (calSet <= calNow) {
        // Today Set time passed, count to tomorrow
        calSet.add(Calendar.DATE, 1)
    }

    return calSet.timeInMillis
}