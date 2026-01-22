package com.ieschabas.sportshub.data.local.entities

import androidx.room.Entity


@Entity(tableName = "FavoriteTeam",
    primaryKeys = ["userId", "teamId"])
data class FavoriteTeamEntity(
    val userId: String,
    val teamId: String
)
