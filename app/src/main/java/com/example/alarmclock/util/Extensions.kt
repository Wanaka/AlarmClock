package com.example.alarmclock.util

fun Int.add0IfNeeded(): String {
    var newNumber = this.toString()
    if (this < 10) newNumber = "0$this"
    return newNumber
}

fun String.splitting(): List<String> = this.split(":")