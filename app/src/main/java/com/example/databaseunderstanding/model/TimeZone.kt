package com.example.databaseunderstanding.model

import com.example.databaseunderstanding.model.fixture.Paging
import com.google.gson.JsonArray
import com.google.gson.JsonPrimitive

data class TimeZone(
    var get: JsonPrimitive? = null,
    var parameters: JsonArray = JsonArray(),
    var errors: JsonArray = JsonArray(),
    var results: JsonPrimitive? = null,
    var paging: Paging = Paging(),
    var response: List<String> = listOf()
)