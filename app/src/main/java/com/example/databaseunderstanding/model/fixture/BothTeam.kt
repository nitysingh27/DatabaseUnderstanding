package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import com.example.databaseunderstanding.model.teams.Team
import kotlinx.parcelize.Parcelize

@Parcelize
data class BothTeam(
    val home : Team = Team(),
    val away : Team = Team()
) : Parcelable