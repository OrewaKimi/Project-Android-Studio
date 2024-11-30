package com.example.belajarkotlin1.jobsheet9Notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import me.leolin.shortcutbadger.ShortcutBadger

class NotificationService : Service() {

    override fun onCreate() {
        super.onCreate()
        // Create the notification channel
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        sendNotification()
        return START_NOT_STICKY
    }

    private fun sendNotification() {
        val notificationId = 2
        val channelId = "service_channel"

        // Increment the badge count
        BadgeCounterManager.incrementBadgeCount(this)
        val currentBadgeCount = BadgeCounterManager.getBadgeCount(this)

        val notification = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Service Notification")
            .setContentText("This is a notification from a Service!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setNumber(currentBadgeCount) // Display badge count on notification
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(notificationId, notification)

        // Update badge with the current count
        ShortcutBadger.applyCount(this, currentBadgeCount)
    }

    private fun createNotificationChannel() {
        // Only create the channel on Android 8.0 (Oreo) and higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "service_channel"
            val channelName = "Service Notifications"
            val channelDescription = "Notifications for background service"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = channelDescription
            }

            // Register the channel with the system
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
        }
}