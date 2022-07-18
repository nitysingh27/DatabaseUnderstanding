package com.example.databaseunderstanding.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Score(
    var extratime: GoalHomeAway = GoalHomeAway(),
    var fulltime: GoalHomeAway = GoalHomeAway(),
    var halftime: GoalHomeAway = GoalHomeAway(),
    var penalty: GoalHomeAway = GoalHomeAway()
) : Parcelable