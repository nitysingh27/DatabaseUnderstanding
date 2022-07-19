package com.example.databaseunderstanding.model.leagues

import com.example.databaseunderstanding.model.fixture.Paging
import com.google.gson.JsonArray
import com.google.gson.JsonPrimitive

data class LeagueResponseModel(
    var get: JsonPrimitive? = null,
    var parameters: JsonArray = JsonArray(),
    var errors: JsonArray = JsonArray(),
    var results: JsonPrimitive? = null,
    var paging: Paging = Paging(),
    var response: List<LeagueResponse> = listOf(),
)