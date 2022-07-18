package com.example.databaseunderstanding.room.timezone

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TimeZoneDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimeZones(timeZoneCacheEntity: TimeZoneCacheEntity)

    @Query("Select * from TimeZone")
    suspend fun getTimeZones(): List<TimeZoneCacheEntity>

}