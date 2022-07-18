package com.example.databaseunderstanding.room.converters

import androidx.room.TypeConverter
import com.example.databaseunderstanding.model.*
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
}