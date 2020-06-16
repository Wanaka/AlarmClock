package com.example.alarmclock.util

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.alarmclock.R
import com.example.alarmclock.service.AlarmBroadcastReceiver
import com.example.alarmclock.view.TimePickerFragmentDialog

class NavigationImpl : Navigation {

    override fun openTimePicker(supportFragmentManager: FragmentManager) {
        TimePickerFragmentDialog().show(supportFragmentManager, "timePicker")
    }


    override fun createAlarm(context: Context, time: Long, reqCode: Int) {
        val intent = Intent(context, AlarmBroadcastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, reqCode, intent, 0)
        var alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmManager.setExact(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )

        toast(context, context.getString(R.string.alarm_started))

        channel(context) // change position?
    }

    override fun cancelAlarm(context: Context, reqCode: Int) {
        val intent = Intent(context, AlarmBroadcastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, reqCode, intent, 0)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmManager.cancel(pendingIntent)

        toast(context, context.getString(R.string.alarm_cancelled))
    }

    override fun channel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val notificationChannel =
                NotificationChannel(
                    "alarmClockId",
                    "Notifications",
                    NotificationManager.IMPORTANCE_DEFAULT
                )

            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}