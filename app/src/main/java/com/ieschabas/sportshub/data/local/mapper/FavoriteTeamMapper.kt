package com.ieschabas.sportshub.data.local.mapper

import com.ieschabas.sportshub.data.local.entities.ClassificationEntity
import com.ieschabas.sportshub.data.local.entities.FavoriteTeamEntity
import com.ieschabas.sportshub.domain.model.Classification
import com.ieschabas.sportshub.domain.model.FavoriteTeam

fun FavoriteTeamEntity.toDomain(): FavoriteTeam =
    FavoriteTeam(
        userId = userId,
        teamId = teamId
    )

fun FavoriteTeam.toEntity(): FavoriteTeamEntity =
    FavoriteTeamEntity(
        userId = userId,
        teamId = teamId
    )
