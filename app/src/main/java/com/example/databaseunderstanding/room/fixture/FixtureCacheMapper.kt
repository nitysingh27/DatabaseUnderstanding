package com.example.databaseunderstanding.room.fixture

import com.example.databaseunderstanding.model.fixture.FixtureItem
import com.example.databaseunderstanding.util.EntityMapper
import javax.inject.Inject

class FixtureCacheMapper
@Inject
constructor() : EntityMapper<FixtureResponseCacheEntity, FixtureItem> {
    override fun mapEntityToDomain(fixtureResponseCacheEntity: FixtureResponseCacheEntity): FixtureItem {
        return FixtureItem(
            fixture = fixtureResponseCacheEntity.fixture,
            league = fixtureResponseCacheEntity.league,
            score = fixtureResponseCacheEntity.score,
            teams = fixtureResponseCacheEntity.teams,
            goals = fixtureResponseCacheEntity.goals
        )
    }

    override fun mapDomainToEntity(fixturesResponses: FixtureItem): FixtureResponseCacheEntity {
        return FixtureResponseCacheEntity(
            fixture = fixturesResponses.fixture,
            league = fixturesResponses.league,
            score = fixturesResponses.score,
            teams = fixturesResponses.teams,
            goals = fixturesResponses.goals
        )
    }

    fun mapListOfEntityToDomain(list: List<FixtureResponseCacheEntity>): List<FixtureItem> {
        return list.map { mapEntityToDomain(it) }
    }

}