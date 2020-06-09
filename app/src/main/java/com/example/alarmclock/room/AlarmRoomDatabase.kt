package com.example.alarmclock.room

import androidx.room.Database
import androidx.room.RoomDatabase

const val ALARM_DATABASE_NAME = "alarm_database"

@Database(entities = [AlarmItem::class], version = 1, exportSchema = false)
abstract class AlarmRoomDatabase : RoomDatabase() {
    abstract fun alarmDao(): AlarmDao
}