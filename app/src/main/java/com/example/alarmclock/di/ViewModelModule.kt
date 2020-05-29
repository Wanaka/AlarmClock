package com.example.alarmclock.di

import com.example.alarmclock.repository.AlarmClockRepository
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesViewModelFactory(repo: AlarmClockRepository): AlarmClockViewModelFactory {
        return AlarmClockViewModelFactory(repo)
    }
}