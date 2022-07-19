package com.example.databaseunderstanding.model.leagues

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Season(
    var coverage: Coverage = Coverage(),
    var current: Boolean = false,
    var end: String = "",
    var start: String = "",
    var year: Int = 0
) : Parcelable