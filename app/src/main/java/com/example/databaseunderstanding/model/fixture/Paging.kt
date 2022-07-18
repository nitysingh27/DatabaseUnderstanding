package com.example.databaseunderstanding.model.fixture

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Paging(
    var current: Int = 0,
    var total: Int = 0
) : Parcelable