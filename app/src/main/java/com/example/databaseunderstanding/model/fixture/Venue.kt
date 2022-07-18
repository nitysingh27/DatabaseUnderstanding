package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Venue(
    var city: String = "",
    var id: Int = 0,
    var name: String = ""
) : Parcelable