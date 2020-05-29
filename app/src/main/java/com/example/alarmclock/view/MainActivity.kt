package com.example.alarmclock.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.alarmclock.MainApplication
import com.example.alarmclock.R
import com.example.alarmclock.di.ApplicationComponent

class MainActivity : AppCompatActivity() {

    lateinit var component: ApplicationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = (applicationContext as MainApplication).appComp
        component.inject(this)
        setContentView(R.layout.activity_main)
    }

    fun showTimePickerFragment(view: View) {
        component.navigator.openTimePicker(supportFragmentManager)
    }
}
