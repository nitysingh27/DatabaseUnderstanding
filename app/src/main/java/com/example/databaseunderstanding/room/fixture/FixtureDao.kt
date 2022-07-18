package com.example.databaseunderstanding.room.fixture

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FixtureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixture(fixtureResponseCacheEntity: FixtureResponseCacheEntity)

    @Query("Select * from fixtures")
    suspend fun getFixtures(): List<FixtureResponseCacheEntity>

}