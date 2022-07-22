package com.example.databaseunderstanding.model.teams

import com.example.databaseunderstanding.model.fixture.Paging
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive

data class TeamStatisticsResponseModel(
    var get: Any? = null,
    var parameters: JsonObject? = null,
    var errors: JsonArray? = null,
    var results: Any? = null,
    var paging: Paging = Paging(),
    var response: TeamStatisticsResponse? = null,
)