package com.example.databaseunderstanding.model.teams

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data  class Cards(
    var yellow : Minute = Minute(),
    var red : Minute = Minute()
) : Parcelable