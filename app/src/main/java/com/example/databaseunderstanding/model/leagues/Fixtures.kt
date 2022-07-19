package com.example.databaseunderstanding.model.leagues

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fixtures(
    var events: Boolean = false,
    var lineups: Boolean = false,
    var statistics_fixtures: Boolean = false,
    var statistics_players: Boolean = false
) : Parcelable