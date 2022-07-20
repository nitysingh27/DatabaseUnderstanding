package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lineup(
    var formation: String = "",
    var played: Int = 0
) : Parcelable