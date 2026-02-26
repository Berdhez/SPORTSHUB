package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.remote.SportsHubApi
import com.ieschabas.sportshub.data.remote.dto.toDomain
import com.ieschabas.sportshub.di.DataSourceApi
import com.ieschabas.sportshub.domain.model.Player
import com.ieschabas.sportshub.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@DataSourceApi
class PlayerRepositoryApiImpl @Inject constructor(
    private val api: SportsHubApi
) : PlayerRepository {

    override fun observePlayers(): Flow<List<Player>> = flow {
        emit(api.getPlayers().map { it.toDomain() })
    }

    override fun observePlayersByTeam(teamId: String): Flow<List<Player>> = flow {
        emit(api.getPlayersByTeam(teamId).map { it.toDomain() })
    }

    override suspend fun getPlayer(id: String): Player? =
        runCatching { api.getPlayer(id).toDomain() }.getOrNull()
}
