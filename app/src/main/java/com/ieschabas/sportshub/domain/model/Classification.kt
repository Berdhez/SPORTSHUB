package com.ieschabas.sportshub.domain.model

data class Classification(
    val id: String,
    val teamId: String,
    val clubId: String,
    val gamesPlayed: Int,
    val victories: Int,
    val lost: Int,
    val ties: Int,
    val totalPoints: Int,
    val leagueId: String,
)
