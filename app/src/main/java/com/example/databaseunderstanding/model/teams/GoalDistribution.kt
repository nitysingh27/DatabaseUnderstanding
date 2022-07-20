package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GoalDistribution(
    var average: FixtureGoals = FixtureGoals(),
    var minute: Minute = Minute(),
    var total: FixtureGoals = FixtureGoals()
) : Parcelable