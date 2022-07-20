package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticsFixture(
    var played: FixtureGoals = FixtureGoals(),
    var wins: FixtureGoals = FixtureGoals(),
    var draws: FixtureGoals = FixtureGoals(),
    var loses: FixtureGoals = FixtureGoals(),
) : Parcelable