package com.ieschabas.sportshub.data.local.mapper

import com.ieschabas.sportshub.data.local.entities.LeagueEntity
import com.ieschabas.sportshub.data.local.entities.MatchEntity
import com.ieschabas.sportshub.domain.model.League
import com.ieschabas.sportshub.domain.model.Match

fun LeagueEntity.toDomain(): League =
    League(
        id = id,
        name = name,
        country = country,
        season = season,
        logoUrl = logoUrl,

        )
fun LeagueEntity.toEntity(): LeagueEntity =
    LeagueEntity(
        id = id,
        name = name,
        country = country,
        season = season,
        logoUrl = logoUrl,

        )