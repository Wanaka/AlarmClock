package com.example.alarmclock.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alarmclock.repository.AlarmClockRepository
import com.example.alarmclock.view.alarmClock.AlarmClockViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass
@Suppress("UNCHECKED_CAST")
class AlarmClockViewModelFactory @Inject constructor(private val repo: AlarmClockRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlarmClockViewModel::class.java)) {
            return AlarmClockViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}