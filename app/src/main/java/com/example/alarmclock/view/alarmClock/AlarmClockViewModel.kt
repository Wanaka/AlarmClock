package com.example.alarmclock.view.alarmClock

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclock.repository.AlarmClockRepository
import com.example.alarmclock.room.AlarmItem
import com.example.alarmclock.util.add0IfNeeded
import kotlinx.coroutines.launch

class AlarmClockViewModel constructor(var repo: AlarmClockRepository) : ViewModel() {

    val getList: LiveData<List<AlarmItem>> = repo.getList()

    fun setAlarmTime(hourOfDay: Int, minute: Int) = viewModelScope.launch {
        repo.insert(AlarmItem(0, correctTime(hourOfDay, minute), isOn = true))
    }

    fun update(id: Int, hourOfDay: Int, minute: Int, isOn: Boolean) = viewModelScope.launch {
        repo.update(AlarmItem(id, correctTime(hourOfDay, minute), isOn))
    }

    fun delete(alarmItem: AlarmItem) = viewModelScope.launch {
        repo.delete(alarmItem)
    }


    private fun correctTime(hourOfDay: Int, minuteOfDay: Int): String =
        "${hourOfDay.add0IfNeeded()}:${minuteOfDay.add0IfNeeded()}"
}