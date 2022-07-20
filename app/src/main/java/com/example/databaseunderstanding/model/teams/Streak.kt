package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Streak(
    var draws: Int = 0,
    var loses: Int = 0,
    var wins: Int = 0
) : Parcelable