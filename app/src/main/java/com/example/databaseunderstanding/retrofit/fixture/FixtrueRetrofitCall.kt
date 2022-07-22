package com.example.databaseunderstanding.retrofit.fixture

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FixtrueRetrofitCall {

    @Headers(
        "X-RapidAPI-Key:d2583ed4d2msha37070d64d26abep11c72fjsne60207b6bdd2",
        "X-RapidAPI-Host:api-football-v1.p.rapidapi.com"
    )
    @GET("v3/fixtures")
    suspend fun getListOfFixtures(@Query("date") date : String): JsonObject

}