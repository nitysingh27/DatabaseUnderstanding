package com.example.databaseunderstanding.room.team

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(teamInformationCacheEntity: TeamInformationCacheEntity)

    @Query("Select * from teamInformation where leagueID=:leagueId AND year=:year")
    suspend fun getTeams(leagueId: Int, year: Int): List<TeamInformationCacheEntity>
}