package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Team(
    var code: String = "",
    var country: String = "",
    var founded: Int = 0,
    var id: Int = 0,
    var logo: String = "",
    var name: String = "",
    var national: Boolean = false,
    var winner: @RawValue Any? = null
) : Parcelable