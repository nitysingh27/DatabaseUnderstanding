package com.example.databaseunderstanding.model.teams

import com.example.databaseunderstanding.model.fixture.Paging
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive

data class TeamStatisticsResponseModel(
    var get: JsonPrimitive? = null,
    var parameters: JsonObject = JsonObject(),
    var errors: JsonArray = JsonArray(),
    var results: JsonPrimitive? = null,
    var paging: Paging = Paging(),
    var response: TeamStatisticsResponse = TeamStatisticsResponse(),
)