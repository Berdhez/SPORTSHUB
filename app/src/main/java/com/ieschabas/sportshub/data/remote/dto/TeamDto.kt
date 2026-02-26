package com.ieschabas.sportshub.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.ieschabas.sportshub.domain.model.Team

data class TeamDto(
    @SerializedName("id")       val id: String,
    @SerializedName("leagueId") val leagueId: String,
    @SerializedName("clubId")   val clubId: String,
    @SerializedName("name")     val name: String,
    @SerializedName("city")     val city: String,
    @SerializedName("founded")  val founded: Int?,
    @SerializedName("crestUrl") val crestUrl: String?,
)

fun TeamDto.toDomain() = Team(
    id       = id,
    leagueId = leagueId,
    clubId   = clubId,
    name     = name,
    city     = city,
    founded  = founded,
    crestUrl = crestUrl,
)
