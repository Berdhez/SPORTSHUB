package com.ieschabas.sportshub.domain.repository

import com.ieschabas.sportshub.domain.model.Club
import kotlinx.coroutines.flow.Flow

interface ClubRepository {
    fun observeClubs(): Flow<List<Club>>

    suspend fun getClub(id: String): Club?
}