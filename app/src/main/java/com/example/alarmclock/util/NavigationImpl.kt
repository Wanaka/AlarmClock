package com.example.alarmclock.util

import androidx.fragment.app.FragmentManager
import com.example.alarmclock.view.TimePickerFragmentDialog

class NavigationImpl : Navigation {

    override fun openTimePicker(supportFragmentManager: FragmentManager) {
        TimePickerFragmentDialog().show(supportFragmentManager, "timePicker")
    }
}