package com.example.alarmclock.repository

import android.util.Log.d
import androidx.lifecycle.LiveData
import com.example.alarmclock.room.AlarmDao
import com.example.alarmclock.room.AlarmItem

class AlarmClockRepositoryImpl constructor(private val alarmDAO: AlarmDao) : AlarmClockRepository {

    override suspend fun insert(alarmItem: AlarmItem) {
        alarmDAO.insert(alarmItem)
    }

    override suspend fun update(alarmItem: AlarmItem) {
        d(",,", "update")
    }

    override suspend fun delete(alarmItem: AlarmItem) {
        alarmDAO.delete(alarmItem)
    }

    override fun getList(): LiveData<List<AlarmItem>> = alarmDAO.getList()
}