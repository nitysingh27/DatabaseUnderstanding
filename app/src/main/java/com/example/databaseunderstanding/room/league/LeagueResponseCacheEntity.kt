package com.example.databaseunderstanding.room.league

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.databaseunderstanding.model.fixture.League
import com.example.databaseunderstanding.model.leagues.Country
import com.example.databaseunderstanding.model.leagues.Season
import kotlinx.parcelize.RawValue

@Entity(tableName = "LeagueResponse")
data class LeagueResponseCacheEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    var country: Country = Country(),
    var league: League = League(),
    var seasons: @RawValue List<Season> = listOf()
)