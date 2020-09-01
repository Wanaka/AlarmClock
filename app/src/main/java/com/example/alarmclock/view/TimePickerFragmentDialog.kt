package com.example.alarmclock.view

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.*
import android.content.Context
import android.os.Bundle
import android.util.Log.d
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.alarmclock.util.NavigationImpl
import com.example.alarmclock.util.calendar
import com.example.alarmclock.util.getAlarmCalendar
import com.example.alarmclock.util.reqCode
import com.example.alarmclock.view.alarmClock.AlarmClockViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class TimePickerFragmentDialog : DialogFragment(), OnTimeSetListener {

    private val viewModel by viewModel<AlarmClockViewModel>()
    private val navigator: NavigationImpl by inject()


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return TimePickerDialog(
            activity,
            this,
            calendar().get(Calendar.HOUR_OF_DAY),
            calendar().get(Calendar.MINUTE),
            true
        )
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        val reqCode = reqCode()
        navigator.createAlarm(context!!, getAlarmCalendar(hourOfDay, minute), reqCode)
        viewModel.setAlarmTime(hourOfDay, minute, reqCode)
    }
}