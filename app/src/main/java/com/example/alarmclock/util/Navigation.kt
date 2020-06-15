package com.example.alarmclock.util

import android.content.Context
import androidx.fragment.app.FragmentManager

interface Navigation {
    fun openTimePicker(supportFragmentManager: FragmentManager)
    fun createAlarm(c: Context, time: Long, reqCode: Int)
    fun cancelAlarm(context: Context, reqCode: Int)
    fun channel(context: Context)
}