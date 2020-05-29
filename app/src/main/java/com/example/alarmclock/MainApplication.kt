package com.example.alarmclock

import android.app.Application
import com.example.alarmclock.di.ApplicationComponent
import com.example.alarmclock.di.DaggerApplicationComponent

class MainApplication : Application() {
    val appComp: ApplicationComponent = DaggerApplicationComponent.create()
}