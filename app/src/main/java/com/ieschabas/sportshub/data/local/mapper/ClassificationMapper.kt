package com.ieschabas.sportshub.data.local.mapper

import com.ieschabas.sportshub.data.local.entities.ClassificationEntity
import com.ieschabas.sportshub.domain.model.Classification

fun ClassificationEntity.toDomain(): Classification =
    Classification(
        id = id,
        teamId = teamId,
        clubId = clubId,
        gamesPlayed = gamesPlayed,
        victories = victories,
        lost = lost,
        ties = ties,
        totalPoints = totalPoints
    )

fun Classification.toEntity(): ClassificationEntity =
    ClassificationEntity(
        id = id,
        teamId = teamId,
        clubId = clubId,
        gamesPlayed = gamesPlayed,
        victories = victories,
        lost = lost,
        ties = ties,
        totalPoints = totalPoints
    )
