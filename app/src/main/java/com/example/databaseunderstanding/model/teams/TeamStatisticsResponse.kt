package com.example.databaseunderstanding.model.teams

import com.example.databaseunderstanding.model.fixture.League

data class TeamStatisticsResponse(
    var biggest: StatisticsBiggest? = StatisticsBiggest(),
    var cards: Any? = null,
    var clean_sheet: Any? = null,
    var failed_to_score: Any? = null,
    var fixtures: Any? = null,
    var form: String = "",
    var goals: Any? = null,
    var league: League = League(),
    var lineups: Any? = null,
    var penalty: Any? = null,
    var team: Any? = null
)