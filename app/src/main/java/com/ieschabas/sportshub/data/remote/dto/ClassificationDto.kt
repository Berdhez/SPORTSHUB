package com.ieschabas.sportshub.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.ieschabas.sportshub.domain.model.Classification

data class ClassificationDto(
    @SerializedName("id")          val id: String,
    @SerializedName("teamId")      val teamId: String,
    @SerializedName("clubId")      val clubId: String,
    @SerializedName("gamesPlayed") val gamesPlayed: Int,
    @SerializedName("victories")   val victories: Int,
    @SerializedName("lost")        val lost: Int,
    @SerializedName("ties")        val ties: Int,
    @SerializedName("totalPoints") val totalPoints: Int,
    @SerializedName("leagueId")    val leagueId: String,
)

fun ClassificationDto.toDomain() = Classification(
    id          = id,
    teamId      = teamId,
    clubId      = clubId,
    gamesPlayed = gamesPlayed,
    victories   = victories,
    lost        = lost,
    ties        = ties,
    totalPoints = totalPoints,
    leagueId    = leagueId,
)
