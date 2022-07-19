package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import com.example.databaseunderstanding.model.teams.Venue
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fixture(
    var date: String = "",
    var id: Int = 0,
    var periods: Periods = Periods(),
    var referee: String = "",
    var status: Status = Status(),
    var timestamp: Int = 0,
    var timezone: String = "",
    var venue: Venue = Venue()
) : Parcelable