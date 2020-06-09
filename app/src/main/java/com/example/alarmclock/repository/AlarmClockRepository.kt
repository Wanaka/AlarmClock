package com.example.alarmclock.repository

import androidx.lifecycle.LiveData
import com.example.alarmclock.room.AlarmItem

interface AlarmClockRepository {

    suspend fun insert(alarmItem: AlarmItem)

    suspend fun update(alarmItem: AlarmItem)

    suspend fun delete(alarmItem: AlarmItem)

    fun getList(): LiveData<List<AlarmItem>>
}