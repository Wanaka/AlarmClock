package com.example.alarmclock.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarm_table")
data class AlarmItem(

    @PrimaryKey
    @ColumnInfo(name = "alarm")
    var alarm: String,

    @ColumnInfo(name = "is_on")
    var isOn: Boolean
)