package com.example.alarmclock.service

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.alarmclock.R
import com.example.alarmclock.view.MainActivity

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, p1: Intent?) {
        createNotification(context)
    }

    private fun createNotification(context: Context) {
        var resultIntent = Intent(context, MainActivity::class.java)
        var resultPendingIntent =
            PendingIntent.getActivity(context, 2, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        var notification = NotificationCompat.Builder(context, "alarmClockId")
            .setContentTitle(context.getString(R.string.notification_title))
            .setContentText(context.getString(R.string.notification_content_text))
            .setSmallIcon(R.drawable.ic_alarm)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(resultPendingIntent)

        var notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(200, notification.build())
    }
}