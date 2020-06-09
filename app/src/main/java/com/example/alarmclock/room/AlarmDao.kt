package com.example.alarmclock.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AlarmDao {

    @Query("SELECT * FROM alarm_table")
    fun getList(): LiveData<List<AlarmItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(alarmItem: AlarmItem)

    @Update
    suspend fun update(alarmItem: AlarmItem)

    @Delete
    suspend fun delete(alarmItem: AlarmItem)
}