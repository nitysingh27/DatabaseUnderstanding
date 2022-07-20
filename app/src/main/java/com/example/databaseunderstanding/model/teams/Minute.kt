package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Minute(
    var `0-15`: X015 = X015(),
    var `106-120`: X015 = X015(),
    var `16-30`: X015 = X015(),
    var `31-45`: X015 = X015(),
    var `46-60`: X015 = X015(),
    var `61-75`: X015 = X015(),
    var `76-90`: X015 = X015(),
    var `91-105`: X015 = X015()
) : Parcelable