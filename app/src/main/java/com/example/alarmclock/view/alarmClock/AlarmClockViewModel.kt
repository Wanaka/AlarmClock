package com.example.alarmclock.view.alarmClock

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclock.repository.AlarmClockRepository
import com.example.alarmclock.room.AlarmItem
import com.example.alarmclock.util.correctTime
import kotlinx.coroutines.launch
import org.koin.ext.scope

class AlarmClockViewModel constructor(var repo: AlarmClockRepository) : ViewModel() {

    val stateLiveData = MutableLiveData(Status.IDLE)


    fun getList(): LiveData<List<AlarmItem>> = repo.getList()

    fun setAlarmTime(hourOfDay: Int, minute: Int, reqCode: Int) = viewModelScope.launch {
        setStatus(Status.LOADING)
//        d(",,,", "status 1: ${getStatus()}")
       var t = repo.insert(AlarmItem(0, correctTime(hourOfDay, minute), isOn = true, reqCode = reqCode))
        setStatus(Status.SUCCESS)
//        d(",,,", "status 2: ${getStatus()}")
    }

    fun getStatus(): Status? = stateLiveData.value

    fun setStatus(status: Status) {
        stateLiveData.value = status
    }

    fun update(id: Int, hourOfDay: Int, minute: Int, isOn: Boolean, reqCode: Int) =
        viewModelScope.launch {
            repo.update(AlarmItem(id, correctTime(hourOfDay, minute), isOn, reqCode))
        }

    fun delete(alarmItem: AlarmItem) = viewModelScope.launch {
        repo.delete(alarmItem)
    }

    fun add(a: Int, b: Int): Int = a + b
}

enum class Status() {
    IDLE, LOADING, SUCCESS, FAILED
}