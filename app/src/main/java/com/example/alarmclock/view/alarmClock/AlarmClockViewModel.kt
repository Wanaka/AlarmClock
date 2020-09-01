package com.example.alarmclock.view.alarmClock

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclock.repository.AlarmClockRepository
import com.example.alarmclock.room.AlarmItem
import com.example.alarmclock.util.correctTime
import kotlinx.coroutines.launch


class AlarmClockViewModel constructor(var repo: AlarmClockRepository) : ViewModel() {

    fun getList(): LiveData<List<AlarmItem>> = repo.getList()

    fun setAlarmTime(hourOfDay: Int, minute: Int, reqCode: Int) = viewModelScope.launch {
        repo.insert(AlarmItem(0, correctTime(hourOfDay, minute), isOn = true, reqCode = reqCode))
    }

    fun update(id: Int, hourOfDay: Int, minute: Int, isOn: Boolean, reqCode: Int) =
        viewModelScope.launch {
            repo.update(AlarmItem(id, correctTime(hourOfDay, minute), isOn, reqCode))
        }

    fun delete(alarmItem: AlarmItem) = viewModelScope.launch {
        repo.delete(alarmItem)
    }

}