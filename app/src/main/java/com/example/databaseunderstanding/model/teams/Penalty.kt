package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Penalty(
    var missed: X015 = X015(),
    var scored: X015 = X015(),
    var total: Int = 0
) : Parcelable