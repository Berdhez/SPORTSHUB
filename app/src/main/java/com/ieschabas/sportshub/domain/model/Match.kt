package com.ieschabas.sportshub.domain.model

data class Match(
    val id: String,
    val leagueId: String,
    val dateUtc: String,
    val homeTeamId: String,
    val awayTeamId: String,
    val homeScore: Int?,
    val awayScore: Int?,
    val status: String,
)
