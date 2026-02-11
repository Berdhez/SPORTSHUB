package com.ieschabas.sportshub.domain.model


data class Team (
    val id: String,
    val leagueId: String,
    val clubId: String,
    val name: String,
    val city: String,
    val founded: Int?,
    val crestUrl: String?
)


