package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticsBiggest(
    var goals: Goals = Goals(),
    var loses: FixtureGoals = FixtureGoals(),
    var streak: Streak = Streak(),
    var wins: FixtureGoals = FixtureGoals()
) : Parcelable