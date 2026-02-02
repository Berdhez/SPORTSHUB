package com.ieschabas.sportshub.data.local.mapper

import com.ieschabas.sportshub.data.local.entities.MatchEntity
import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import com.ieschabas.sportshub.domain.model.Match

fun MatchEntity.toDomain(): Match =
    Match(
        id = id,
        leagueId = leagueId,
        dateUtc = dateUtc,
        homeTeamId = homeTeamId,
        awayTeamId = awayTeamId,
        homeScore = homeScore,
        awayScore = awayScore,
        status = status,

)
fun Match.toEntity(): MatchEntity =
    MatchEntity(
        id = id,
        leagueId = leagueId,
        dateUtc = dateUtc,
        homeTeamId = homeTeamId,
        awayTeamId = awayTeamId,
        homeScore = homeScore,
        awayScore = awayScore,
        status = status,

    )
