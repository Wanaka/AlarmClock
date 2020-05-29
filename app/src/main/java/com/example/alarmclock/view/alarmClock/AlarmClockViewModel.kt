package com.example.alarmclock.view.alarmClock

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.alarmclock.model.AlarmItem
import com.example.alarmclock.repository.AlarmClockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AlarmClockViewModel  @Inject constructor(private var repo: AlarmClockRepository): ViewModel() {

    val alarmList: LiveData<List<AlarmItem>> = liveData {
        emit(fakeDataViewModel())
    }

    private suspend fun fakeDataViewModel(): List<AlarmItem> = withContext(Dispatchers.Default) {
        repo.fakeDataRepo()
    }
}