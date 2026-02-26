package com.ieschabas.sportshub.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.ieschabas.sportshub.domain.model.Player

data class PlayerDto(
    @SerializedName("id")          val id: String,
    @SerializedName("teamId")      val teamId: String,
    @SerializedName("name")        val name: String,
    @SerializedName("position")    val position: String,
    @SerializedName("number")      val number: Int?,
    @SerializedName("nationality") val nationality: String?,
)

fun PlayerDto.toDomain() = Player(
    id          = id,
    teamId      = teamId,
    name        = name,
    position    = position,
    number      = number,
    nationality = nationality,
)
