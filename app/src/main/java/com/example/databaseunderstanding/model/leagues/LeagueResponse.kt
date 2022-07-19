package com.example.databaseunderstanding.model.leagues

import android.os.Parcelable
import com.example.databaseunderstanding.model.fixture.League
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class LeagueResponse(
    var country: Country = Country(),
    var league: League = League(),
    var seasons: @RawValue List<Season> = listOf()
) : Parcelable