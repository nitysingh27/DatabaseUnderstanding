package com.example.databaseunderstanding.room.league

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LeagueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeague(fixtureResponseCacheEntity: LeagueResponseCacheEntity)

    @Query("Select * from LeagueResponse")
    suspend fun getLeague(): List<LeagueResponseCacheEntity>

}