package com.example.databaseunderstanding.room.fixture

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.databaseunderstanding.model.fixture.*
import java.io.Serializable

@Entity(tableName = "kjbnkj")
class FixtrueCalls2 (
    @PrimaryKey(autoGenerate = true)
val primaryKey: Int = 0,

    var fixture: Fixture = Fixture(),
    var goals: GoalHomeAway = GoalHomeAway(),
    var league: League = League(),
    var score: Score = Score(),
    var teams: BothTeam = BothTeam()
    ) : Serializable