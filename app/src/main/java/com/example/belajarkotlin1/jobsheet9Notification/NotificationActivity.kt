package com.example.belajarkotlin1.jobsheet9Notification

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarkotlin1.R
import me.leolin.shortcutbadger.ShortcutBadger
import java.util.*

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            checkAndRequestExactAlarmPermission()
        }

        val buttonSetAlarm = findViewById<Button>(R.id.buttonSetAlarm)
        buttonSetAlarm.setOnClickListener {
            Toast.makeText(this, "Setting Alarm...", Toast.LENGTH_SHORT).show()
            Log.d("NotificationActivity", "Button Set Alarm clicked")
            setAlarmNotification()
        }

        val buttonStartService = findViewById<Button>(R.id.buttonStartService)
        buttonStartService.setOnClickListener {
            val serviceIntent = Intent(this, NotificationService::class.java)
            startService(serviceIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Reset the badge count when the app is opened
        BadgeCounterManager.resetBadgeCount(this)
        ShortcutBadger.removeCount(this)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun checkAndRequestExactAlarmPermission() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        if (!alarmManager.canScheduleExactAlarms()) {
            val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM).apply {
                data = android.net.Uri.parse("package:$packageName")
            }
            startActivity(intent)
        }
    }

    private fun setAlarmNotification() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val triggerTime = Calendar.getInstance().apply {
            add(Calendar.SECOND, 5)
        }.timeInMillis

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent)
        Toast.makeText(this, "Alarm Set for 5 seconds", Toast.LENGTH_SHORT).show()
        }
}