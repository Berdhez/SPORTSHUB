package com.ieschabas.sportshub.data.local.entities


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Club")
data class ClubEntity(
    @PrimaryKey val id: String,
    val name: String,
)