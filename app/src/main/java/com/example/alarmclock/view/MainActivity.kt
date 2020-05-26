package com.example.alarmclock.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.alarmclock.R
import com.example.alarmclock.util.NavigationImpl

class MainActivity : AppCompatActivity() {

    lateinit var navigation: NavigationImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation = NavigationImpl()
    }

    fun showTimePickerFragment(view: View) {
        navigation.openTimePicker(supportFragmentManager)
    }

}
