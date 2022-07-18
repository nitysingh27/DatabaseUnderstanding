package com.example.databaseunderstanding.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Periods(
    var first: Int = 0,
    var second: Int = 0
) : Parcelable