package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Status(
    var elapsed: Int = 0,
    var long: String = "",
    var short: String = ""
)  : Parcelable