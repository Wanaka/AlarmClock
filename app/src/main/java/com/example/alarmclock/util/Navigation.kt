package com.example.alarmclock.util

import androidx.fragment.app.FragmentManager

interface Navigation {
    fun openTimePicker(supportFragmentManager: FragmentManager)
}