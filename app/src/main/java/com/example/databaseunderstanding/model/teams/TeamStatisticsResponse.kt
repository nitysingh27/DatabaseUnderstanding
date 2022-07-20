package com.example.databaseunderstanding.model.teams

import com.example.databaseunderstanding.model.fixture.League

data class TeamStatisticsResponse(
    var biggest: StatisticsBiggest = StatisticsBiggest(),
    var cards: Cards = Cards(),
    var clean_sheet: FixtureGoals = FixtureGoals(),
    var failed_to_score: FixtureGoals = FixtureGoals(),
    var fixtures: StatisticsFixture = StatisticsFixture(),
    var form: String = "",
    var goals: GoalStatistics = GoalStatistics(),
    var league: League = League(),
    var lineups: List<Lineup> = listOf(),
    var penalty: Penalty = Penalty(),
    var team: Team = Team()
)