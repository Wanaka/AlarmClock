package com.example.alarmclock.di

import com.example.alarmclock.util.NavigationImpl
import com.example.alarmclock.view.MainActivity
import com.example.alarmclock.view.alarmClock.AlarmClockFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class])
interface ApplicationComponent {

    var navigator: NavigationImpl

    fun inject(activity: MainActivity)
    fun inject(fragment: AlarmClockFragment)
}
