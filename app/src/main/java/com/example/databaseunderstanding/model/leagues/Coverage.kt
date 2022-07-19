package com.example.databaseunderstanding.model.leagues

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coverage(
    var fixtures: Fixtures = Fixtures(),
    var injuries: Boolean = false,
    var odds: Boolean = false,
    var players: Boolean = false,
    var predictions: Boolean = false,
    var standings: Boolean = false,
    var top_assists: Boolean = false,
    var top_cards: Boolean = false,
    var top_scorers: Boolean = false
) : Parcelable