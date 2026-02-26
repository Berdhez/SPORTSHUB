package com.ieschabas.sportshub.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.ieschabas.sportshub.domain.model.Match

data class MatchDto(
    @SerializedName("id")         val id: String,
    @SerializedName("leagueId")   val leagueId: String,
    @SerializedName("dateUtc")    val dateUtc: String,
    @SerializedName("homeTeamId") val homeTeamId: String,
    @SerializedName("awayTeamId") val awayTeamId: String,
    @SerializedName("homeScore")  val homeScore: Int?,
    @SerializedName("awayScore")  val awayScore: Int?,
    @SerializedName("status")     val status: String,
)

fun MatchDto.toDomain() = Match(
    id         = id,
    leagueId   = leagueId,
    dateUtc    = dateUtc,
    homeTeamId = homeTeamId,
    awayTeamId = awayTeamId,
    homeScore  = homeScore,
    awayScore  = awayScore,
    status     = status,
)
