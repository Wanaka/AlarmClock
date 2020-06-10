package com.example.alarmclock.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarm_table")
data class AlarmItem(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "alarm")
    var alarm: String,

    @ColumnInfo(name = "is_on")
    var isOn: Boolean
)