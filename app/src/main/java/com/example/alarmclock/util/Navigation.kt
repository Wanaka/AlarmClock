package com.example.alarmclock.util

import androidx.fragment.app.FragmentManager
import javax.inject.Inject

interface Navigation {
    fun openTimePicker(supportFragmentManager: FragmentManager)
}