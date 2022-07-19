package com.example.databaseunderstanding.room.converters

import androidx.room.TypeConverter
import com.example.databaseunderstanding.model.fixture.*
import com.example.databaseunderstanding.model.leagues.Country
import com.example.databaseunderstanding.model.leagues.Season
import com.example.databaseunderstanding.model.teams.Team
import com.example.databaseunderstanding.model.teams.Venue
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    @TypeConverter
    fun fromListString(stringList  : List<String>) : String{
        return Gson().toJson(stringList)
    }

    @TypeConverter
    fun getAddressList(listOfString: String?): List<String?>? {
        return Gson().fromJson(
            listOfString,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

    @TypeConverter
    fun fromTeams(fixture: BothTeam): String {
        return Gson().toJson(fixture)
    }

    @TypeConverter
    fun toTeams(t: String): BothTeam {
        return Gson().fromJson(t, BothTeam::class.java)
    }

    @TypeConverter
    fun fromScore(fixture: Score): String {
        return Gson().toJson(fixture)
    }

    @TypeConverter
    fun toScore(t: String): Score {
        return Gson().fromJson(t, Score::class.java)
    }

    @TypeConverter
    fun fromFixture(fixture: Fixture): String {
        return Gson().toJson(fixture)
    }

    @TypeConverter
    fun toFixture(t: String): Fixture {
        return Gson().fromJson(t, Fixture::class.java)
    }


    @TypeConverter
    fun fromGoalHomeAway(fixture: GoalHomeAway): String {
        return Gson().toJson(fixture)
    }

    @TypeConverter
    fun toGoalHomeAway(t: String): GoalHomeAway {
        return Gson().fromJson(t, GoalHomeAway::class.java)
    }


    @TypeConverter
    fun fromLeague(fixture: League): String {
        return Gson().toJson(fixture)
    }

    @TypeConverter
    fun toLeague(t: String): League {
        return Gson().fromJson(t, League::class.java)
    }


    @TypeConverter
    fun fromCountry(country: Country): String {
        return Gson().toJson(country)
    }

    @TypeConverter
    fun toCountry(t: String): Country {
        return Gson().fromJson(t, Country::class.java)
    }


    @TypeConverter
    fun fromSeason(fixture: Season): String {
        return Gson().toJson(fixture)
    }

    @TypeConverter
    fun toSeason(t: String): Season {
        return Gson().fromJson(t, Season::class.java)
    }

    @TypeConverter
    fun fromTeam(fixture: Team): String {
        return Gson().toJson(fixture)
    }

    @TypeConverter
    fun toTeam(t: String): Team {
        return Gson().fromJson(t, Team::class.java)
    }

    @TypeConverter
    fun fromVenue(fixture: Venue): String {
        return Gson().toJson(fixture)
    }

    @TypeConverter
    fun toVenue(t: String): Venue {
        return Gson().fromJson(t, Venue::class.java)
    }

    @TypeConverter
    fun fromListSeason(stringList: List<Season>): String {
        return Gson().toJson(stringList)
    }

    @TypeConverter
    fun getSeasonList(listOfString: String?): List<Season?>? {
        return Gson().fromJson(
            listOfString,
            object : TypeToken<List<Season?>?>() {}.type
        )
    }

}