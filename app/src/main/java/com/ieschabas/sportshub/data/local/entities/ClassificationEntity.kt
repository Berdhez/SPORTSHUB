package com.ieschabas.sportshub.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classifications")
data class ClassificationEntity(
    @PrimaryKey val id: String,
    val teamId: String,
    val clubId: String,
    val gamesPlayed: Int,
    val victories: Int,
    val lost: Int,
    val ties: Int,
    val totalPoints: Int
)
