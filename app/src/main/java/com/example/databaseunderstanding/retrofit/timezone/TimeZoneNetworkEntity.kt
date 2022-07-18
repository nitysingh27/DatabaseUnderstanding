package com.example.databaseunderstanding.retrofit.timezone

import com.example.databaseunderstanding.model.Paging
import com.google.gson.JsonArray
import com.google.gson.JsonPrimitive

data class TimeZoneNetworkEntity(
    var get: JsonPrimitive? = null,
    var parameters: JsonArray = JsonArray(),
    var errors: JsonArray = JsonArray(),
    var results: JsonPrimitive? = null,
    var paging: Paging = Paging(),
    var response: List<String> = listOf()
)