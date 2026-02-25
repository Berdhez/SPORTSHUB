package com.ieschabas.sportshub.data.local.mapper

import com.ieschabas.sportshub.data.local.entities.ClubEntity
import com.ieschabas.sportshub.data.local.entities.FavoriteTeamEntity
import com.ieschabas.sportshub.domain.model.Club
import com.ieschabas.sportshub.domain.model.FavoriteTeam

fun ClubEntity.toDomain(): Club =
    Club(
        id= id,
        name = name
    )

fun Club.toEntity(): ClubEntity =
    ClubEntity(
        id= id,
        name = name
    )