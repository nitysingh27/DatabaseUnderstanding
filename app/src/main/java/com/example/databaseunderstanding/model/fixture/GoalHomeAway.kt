package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GoalHomeAway(
    val home : Int? = null,
    val away : Int? = null
) : Parcelable