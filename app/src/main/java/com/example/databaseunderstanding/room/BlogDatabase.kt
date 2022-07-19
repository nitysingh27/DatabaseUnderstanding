package com.example.databaseunderstanding.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.databaseunderstanding.room.converters.TypeConverter
import com.example.databaseunderstanding.room.fixture.FixtureDao
import com.example.databaseunderstanding.room.fixture.FixtureResponseCacheEntity
import com.example.databaseunderstanding.room.league.LeagueDao
import com.example.databaseunderstanding.room.league.LeagueResponseCacheEntity
import com.example.databaseunderstanding.room.team.TeamInformationCacheEntity
import com.example.databaseunderstanding.room.team.TeamsDao
import com.example.databaseunderstanding.room.timezone.TimeZoneCacheEntity
import com.example.databaseunderstanding.room.timezone.TimeZoneDao

@Database(
    entities = [
        FixtureResponseCacheEntity::class,
        TimeZoneCacheEntity::class,
        LeagueResponseCacheEntity::class,
        TeamInformationCacheEntity::class,
    ],
    version = 2
)
@TypeConverters(TypeConverter::class)
abstract class BlogDatabase : RoomDatabase() {
    abstract fun fixtrueDao(): FixtureDao
    abstract fun timeZoneDao(): TimeZoneDao
    abstract fun leagueDao(): LeagueDao
    abstract fun teamsDao(): TeamsDao
    companion object {
        val DATABASE_NAME = "FIXTURES"
    }
}