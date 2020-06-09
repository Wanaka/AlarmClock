package com.example.alarmclock.view

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.*
import android.content.Context
import android.os.Bundle
import android.util.Log.d
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.alarmclock.view.alarmClock.AlarmClockViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class TimePickerFragmentDialog : DialogFragment(), OnTimeSetListener {

    private val viewModel by viewModel<AlarmClockViewModel>()


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(
            activity,
            this,
            hour,
            minute,
            true
        )
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        viewModel.setAlarmTime(hourOfDay, minute)
    }
}