package com.example.databaseunderstanding.retrofit.fixture

import com.example.databaseunderstanding.model.fixture.Paging
import com.example.databaseunderstanding.model.fixture.Parameters
import com.example.databaseunderstanding.model.fixture.FixtureItem
import com.google.gson.JsonArray
import com.google.gson.JsonPrimitive

data class FixtureResponseEntity(
    var get: JsonPrimitive? = null,
    var parameters: Parameters = Parameters(),
    var errors: JsonArray = JsonArray(),
    var results: JsonPrimitive? = null,
    var paging: Paging = Paging(),
    var response: List<FixtureItem> = listOf()
)