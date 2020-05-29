package com.example.alarmclock.repository

import com.example.alarmclock.model.AlarmItem
import javax.inject.Inject

class AlarmClockRepository @Inject constructor() {

    fun fakeDataRepo(): List<AlarmItem> =
        listOf(AlarmItem("07:00", true), AlarmItem("10:00", false))
}