package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Goals(
    var against: FixtureGoals = FixtureGoals(),
    var `for`: FixtureGoals = FixtureGoals()
) : Parcelable