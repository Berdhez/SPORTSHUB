package com.ieschabas.sportshub.domain.model

data class League(
    val id: String,
    val name: String,
    val country: String,
    val season: String,
    val logoUrl: String?
)
