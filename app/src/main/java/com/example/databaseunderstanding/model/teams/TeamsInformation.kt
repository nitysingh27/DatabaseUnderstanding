package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamsInformation(
    var team: Team = Team(),
    var venue: Venue = Venue()
) : Parcelable