package com.ieschabas.sportshub.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class Match(
    val time: String,
    val homeTeam: String,
    val homeLogoRes: Int,
    val awayTeam: String,
    val awayLogoRes: Int,
    val score: String? // null = sin empezar
)
