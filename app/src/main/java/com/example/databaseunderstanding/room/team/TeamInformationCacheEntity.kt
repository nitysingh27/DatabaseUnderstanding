package com.example.databaseunderstanding.room.team

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.databaseunderstanding.model.teams.Team
import com.example.databaseunderstanding.model.teams.Venue

@Entity(tableName = "teamInformation")
data class TeamInformationCacheEntity (

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    var team: Team = Team(),
    var venue: Venue = Venue(),
    var leagueID : Int = 0,
    var year  : Int = 0
)