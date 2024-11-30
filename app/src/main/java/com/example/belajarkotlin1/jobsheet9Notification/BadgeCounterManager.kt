package com.example.belajarkotlin1.jobsheet9Notification

import android.content.Context
import android.content.SharedPreferences

object BadgeCounterManager {
    private const val PREFS_NAME = "notification_badge_prefs"
    private const val KEY_BADGE_COUNT = "badge_count"

    fun getBadgeCount(context: Context): Int {
        val prefs = getPreferences(context)
        return prefs.getInt(KEY_BADGE_COUNT, 0)
    }

    fun incrementBadgeCount(context: Context) {
        val prefs = getPreferences(context)
        val currentCount = getBadgeCount(context)
        prefs.edit().putInt(KEY_BADGE_COUNT, currentCount + 1).apply()
    }

    fun resetBadgeCount(context: Context) {
        val prefs = getPreferences(context)
        prefs.edit().putInt(KEY_BADGE_COUNT, 0).apply()
    }

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
}