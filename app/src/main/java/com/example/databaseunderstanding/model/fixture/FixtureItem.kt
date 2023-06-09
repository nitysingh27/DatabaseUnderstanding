package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FixtureItem(
    var fixture: Fixture = Fixture(),
    var goals: GoalHomeAway = GoalHomeAway(),
    var league: League = League(),
    var score: Score = Score(),
    var teams: BothTeam = BothTeam()
) : Parcelable