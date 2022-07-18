package com.example.databaseunderstanding.model.fixture

import com.google.gson.JsonArray
import com.google.gson.JsonPrimitive

data class FixtureNetworkModel(
    var get: JsonPrimitive? = null,
    var parameters: Parameters = Parameters(),
    var errors: JsonArray = JsonArray(),
    var results: JsonPrimitive? = null,
    var paging: Paging = Paging(),
    var response: List<FixtureItem> = listOf()
)