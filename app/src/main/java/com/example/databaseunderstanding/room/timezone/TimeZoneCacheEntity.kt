package com.example.databaseunderstanding.room.timezone

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "TimeZone")
data class TimeZoneCacheEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val timeZone: List<String> = listOf()
) : Serializable