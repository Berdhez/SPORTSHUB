package com.ieschabas.sportshub.domain.model

data class Player(
    val id: String,
    val teamId: String,
    val name: String,
    val position: String,
    val number: Int?,
    val nationality: String?
)
