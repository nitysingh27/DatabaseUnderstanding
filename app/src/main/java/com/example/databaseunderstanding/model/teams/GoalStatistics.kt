package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GoalStatistics(
    var `for` : GoalDistribution= GoalDistribution(),
    var against :GoalDistribution=GoalDistribution()
) : Parcelable