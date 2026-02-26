package com.ieschabas.sportshub.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.ieschabas.sportshub.domain.model.League

data class LeagueDto(
    @SerializedName("id")      val id: String,
    @SerializedName("name")    val name: String,
    @SerializedName("country") val country: String,
    @SerializedName("season")  val season: String,
    @SerializedName("logoUrl") val logoUrl: String?,
)

fun LeagueDto.toDomain() = League(
    id      = id,
    name    = name,
    country = country,
    season  = season,
    logoUrl = logoUrl,
)
