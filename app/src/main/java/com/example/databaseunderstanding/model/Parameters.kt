package com.example.databaseunderstanding.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Parameters(
    var date: String = ""
) : Parcelable