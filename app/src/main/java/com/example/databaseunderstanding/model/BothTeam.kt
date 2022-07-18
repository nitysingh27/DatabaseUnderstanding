package com.example.databaseunderstanding.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BothTeam(
    val home : Teams = Teams(),
    val away : Teams = Teams()
) : Parcelable