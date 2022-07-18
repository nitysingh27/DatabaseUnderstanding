package com.example.databaseunderstanding.di

import com.example.databaseunderstanding.repository.fixtures.FixtureRepository
import com.example.databaseunderstanding.repository.timeZone.TimeZoneRepository
import com.example.databaseunderstanding.retrofit.fixture.FixtrueRetrofitCall
import com.example.databaseunderstanding.retrofit.fixture.FixtureMapper
import com.example.databaseunderstanding.retrofit.timezone.TimeZoneMapper
import com.example.databaseunderstanding.retrofit.timezone.TimeZoneRetrofitCall
import com.example.databaseunderstanding.room.fixture.FixtureCacheMapper
import com.example.databaseunderstanding.room.fixture.FixtureDao
import com.example.databaseunderstanding.room.timezone.TimeZoneDao
import com.example.databaseunderstanding.room.timezone.TimeZoneMapperCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesMainRepository(
        fixtureDao: FixtureDao,
        retrofit: FixtrueRetrofitCall,
        cacheMapper: FixtureCacheMapper,
        networkMapper: FixtureMapper
    ): FixtureRepository {
        return FixtureRepository(fixtureDao, retrofit, cacheMapper, networkMapper)
    }

    @Singleton
    @Provides
    fun providesTimezoneRepository(
        timeZoneMapper: TimeZoneMapper,
        timeZoneRetrofitCall: TimeZoneRetrofitCall,
        timeZoneDao: TimeZoneDao,
        timeZoneMapperCache: TimeZoneMapperCache
    ) : TimeZoneRepository {
        return TimeZoneRepository(
            timeZoneRetrofitCall = timeZoneRetrofitCall,
            timeZoneMapper = timeZoneMapper,
            timeZoneDao = timeZoneDao,
            timeZoneMapperCache = timeZoneMapperCache
        )
    }
}