package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class FixtureGoals(
    var away: @RawValue Any? = null,
    var home: @RawValue Any? = null,
    var total: @RawValue Any? = null,
) : Parcelable