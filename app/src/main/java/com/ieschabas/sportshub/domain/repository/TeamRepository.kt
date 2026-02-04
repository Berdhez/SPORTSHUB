package com.ieschabas.sportshub.domain.repository

import com.ieschabas.sportshub.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface TeamRepository {

    fun observeTeams(): Flow<List<Team>>

    suspend fun getTeam(id: String): Team?
}
