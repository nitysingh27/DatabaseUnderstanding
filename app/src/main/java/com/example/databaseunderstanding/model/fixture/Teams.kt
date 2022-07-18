package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Teams(
    var id: Int = 0,
    var logo: String = "",
    var name: String = "",
    var winner: @RawValue Any? = null
) : Parcelable