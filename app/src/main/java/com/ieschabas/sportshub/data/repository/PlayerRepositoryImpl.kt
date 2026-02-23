package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.local.dao.PlayerDao
import com.ieschabas.sportshub.data.local.mapper.toDomain
import com.ieschabas.sportshub.domain.model.Player
import com.ieschabas.sportshub.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class PlayerRepositoryImpl @Inject constructor(
    private val playerDao: PlayerDao
) : PlayerRepository {

    override fun observePlayers(): Flow<List<Player>> =
        playerDao.observePlayers()
            .map { list -> list.map { it.toDomain() } }

    override fun observePlayersByTeam(teamId: String): Flow<List<Player>> =
        playerDao.observePlayersByTeam(teamId).map { list -> list.map { it.toDomain() } }

    override suspend fun getPlayer(id: String): Player? =
        playerDao.getPlayer(id)?.toDomain()
}
