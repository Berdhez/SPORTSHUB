package com.ieschabas.sportshub.data.local.mapper

import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import com.ieschabas.sportshub.domain.model.Player

fun PlayerEntity.toDomain() = Player(
    id = id,
    teamId = teamId,
    name = name,
    position = position,
    number = number,
    nationality = nationality
)


fun Player.toEntity() = PlayerEntity(
    id = id,
    teamId = teamId,
    name = name,
    position = position,
    number = number,
    nationality = nationality
)