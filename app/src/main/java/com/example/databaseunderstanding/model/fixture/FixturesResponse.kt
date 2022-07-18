package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class FixturesResponse(
    val fixture: @RawValue Any? = null,
    val league: @RawValue Any? = null,
    val teams: @RawValue Any? = null,
    val goals: @RawValue Any? = null,
    val score: @RawValue Any? = null
) : Parcelable