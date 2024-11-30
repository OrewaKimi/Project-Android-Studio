package com.example.belajarkotlin1.jobsheet9Notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import me.leolin.shortcutbadger.ShortcutBadger
import com.example.belajarkotlin1.R

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create NotificationChannel if Android version is Oreo or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "ALARM_CHANNEL_ID"
            val channel = NotificationChannel(
                channelId,
                "Alarm Notification",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notification channel for alarm"
            }
            notificationManager.createNotificationChannel(channel)
        }

        // Increment the badge count
        BadgeCounterManager.incrementBadgeCount(context)
        val currentBadgeCount = BadgeCounterManager.getBadgeCount(context)

        // Create notification
        val notification = NotificationCompat.Builder(context, "ALARM_CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_alarm)
            .setContentTitle("Alarm Triggered!")
            .setContentText("This is your alarm notification.")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setNumber(currentBadgeCount) // Setting the badge count directly in the notification
            .build()

        // Display notification
        notificationManager.notify(1001, notification)

        // Update badge with the current count using ShortcutBadger
        ShortcutBadger.applyCount(context, currentBadgeCount)
        }
}