package com.example.alarmclock.view

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.*
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragmentDialog : DialogFragment(), OnTimeSetListener {

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
        // Do something with the returned time
//        val tv:TextView = activity.findViewById(R.id.text_view) as TextView
//        tv.text = "Hour : Minute\n${getHourAMPM(hourOfDay)}:$minute ${getAMPM(hourOfDay)}"

    }
}