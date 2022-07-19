package com.example.databaseunderstanding.retrofit.league

import com.example.databaseunderstanding.model.fixture.Paging
import com.example.databaseunderstanding.model.leagues.LeagueResponse
import com.google.gson.JsonArray
import com.google.gson.JsonPrimitive

data class LeagueResponseEntity(
    var get: JsonPrimitive? = null,
    var parameters: JsonArray = JsonArray(),
    var errors: JsonArray = JsonArray(),
    var results: JsonPrimitive? = null,
    var paging: Paging = Paging(),
    var response: List<LeagueResponse> = listOf(),
)