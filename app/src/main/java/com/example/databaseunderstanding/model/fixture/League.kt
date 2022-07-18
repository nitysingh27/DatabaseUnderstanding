package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class League(
    var country: String = "",
    var flag: @RawValue Any? = null,
    var id: Int = 0,
    var logo: String = "",
    var name: String = "",
    var round: String = "",
    var season: Int = 0
) : Parcelable