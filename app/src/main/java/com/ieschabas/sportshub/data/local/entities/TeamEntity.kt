package com.ieschabas.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Team")
data class TeamEntity(
    @PrimaryKey val id: String,
    val leagueId: String,
    val clubId: String,
    val name: String,
    val city: String,
    val founded: Int?,
    val crestUrl: String?
)
