package com.example.alarmclock.repository

import com.example.alarmclock.model.AlarmItem

class AlarmClockRepository {

    fun fakeDataRepo(): List<AlarmItem> =
        listOf(AlarmItem("07:00", true), AlarmItem("10:00", false))

}