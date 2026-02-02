package com.ieschabas.sportshub.data.local.mapper

import com.ieschabas.sportshub.data.local.entities.TeamEntity
import com.ieschabas.sportshub.domain.model.Classification
import com.ieschabas.sportshub.domain.model.Team

fun TeamEntity.toDomain(): Team =
    Team(
        id = id,
        leagueId = leagueId,
        clubId = clubId,
        name = name,
        city = city,
        founded = founded,
        crestUrl = crestUrl
    )

fun Team.toEntity(): TeamEntity =
    TeamEntity(
        id = id,
        leagueId = leagueId,
        clubId = clubId,
        name = name,
        city = city,
        founded = founded,
        crestUrl = crestUrl

    )