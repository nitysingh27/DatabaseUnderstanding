package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class X015(
    var percentage: String? = null,
    var total: Int? = null
) : Parcelable