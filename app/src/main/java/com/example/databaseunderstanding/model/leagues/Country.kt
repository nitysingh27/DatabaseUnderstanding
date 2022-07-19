package com.example.databaseunderstanding.model.leagues

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    var code: String = "",
    var flag: String = "",
    var name: String = ""
) : Parcelable