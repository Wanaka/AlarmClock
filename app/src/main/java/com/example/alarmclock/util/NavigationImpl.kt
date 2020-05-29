package com.example.alarmclock.util

import androidx.fragment.app.FragmentManager
import com.example.alarmclock.view.TimePickerFragmentDialog
import javax.inject.Inject

class NavigationImpl @Inject constructor() : Navigation {

    override fun openTimePicker(supportFragmentManager: FragmentManager) {
        TimePickerFragmentDialog().show(supportFragmentManager, "timePicker")
    }
}