package com.ieschabas.sportshub.domain.repository

import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import com.ieschabas.sportshub.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface TeamRepository {

    fun observeTeams(): Flow<List<Team>>

    fun observeTeam(id: String): Flow<Team?>

    suspend fun getTeam(id: String): Team?

    suspend fun getPlayersByTeam(teamId: String): List<PlayerEntity>
}

