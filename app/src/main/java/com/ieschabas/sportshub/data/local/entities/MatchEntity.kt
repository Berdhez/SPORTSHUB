package com.ieschabas.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Match")
data class MatchEntity(
    @PrimaryKey val id: String,
    val leagueId: String,
    val dateUtc: String,
    val homeTeamId: String,
    val awayTeamId: String,
    val homeScore: Int?,
    val awayScore: Int?,
    val status: String,
)
