package com.example.databaseunderstanding.di

import android.content.Context
import androidx.room.Room
import com.example.databaseunderstanding.room.BlogDatabase
import com.example.databaseunderstanding.room.fixture.FixtureDao
import com.example.databaseunderstanding.room.league.LeagueDao
import com.example.databaseunderstanding.room.timezone.TimeZoneDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providesFixtureDb(@ApplicationContext context: Context): BlogDatabase {
        return Room.databaseBuilder(
            context,
            BlogDatabase::class.java,
            BlogDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }


    @Singleton
    @Provides
    fun provideFixtureDao(blogDatabase: BlogDatabase) : FixtureDao {
        return blogDatabase.fixtrueDao()
    }


    @Singleton
    @Provides
    fun providesTimeZoneDao(blogDatabase: BlogDatabase) : TimeZoneDao {
        return blogDatabase.timeZoneDao()
    }

    @Singleton
    @Provides
    fun providesLeagueDao(blogDatabase: BlogDatabase) : LeagueDao {
        return blogDatabase.leagueDao()
    }


}