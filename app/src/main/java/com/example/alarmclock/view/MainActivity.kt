package com.example.alarmclock.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.alarmclock.R
import com.example.alarmclock.util.NavigationImpl
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navigator: NavigationImpl by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showOpenTimePicker(v: View){
        navigator.openTimePicker(supportFragmentManager)
    }
}
