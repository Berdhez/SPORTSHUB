package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import com.ieschabas.sportshub.data.remote.SportsHubApi
import com.ieschabas.sportshub.data.remote.dto.toDomain
import com.ieschabas.sportshub.di.DataSourceApi
import com.ieschabas.sportshub.domain.model.Team
import com.ieschabas.sportshub.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@DataSourceApi
class TeamRepositoryApiImpl @Inject constructor(
    private val api: SportsHubApi
) : TeamRepository {

    override fun observeTeams(): Flow<List<Team>> = flow {
        emit(api.getTeams().map { it.toDomain() })
    }

    override fun observeTeam(id: String): Flow<Team?> = flow {
        emit(runCatching { api.getTeam(id).toDomain() }.getOrNull())
    }

    override suspend fun getTeam(id: String): Team? =
        runCatching { api.getTeam(id).toDomain() }.getOrNull()

    // getPlayersByTeam returns PlayerEntity (Room type); not applicable via API.
    // Returns empty list when using API source — callers should use PlayerRepository instead.
    override suspend fun getPlayersByTeam(teamId: String): List<PlayerEntity> = emptyList()
}
