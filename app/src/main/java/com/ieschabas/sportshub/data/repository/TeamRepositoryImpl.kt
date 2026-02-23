package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.local.dao.TeamDao
import com.ieschabas.sportshub.data.local.dao.PlayerDao
import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import com.ieschabas.sportshub.data.local.mapper.toDomain
import com.ieschabas.sportshub.domain.model.Team
import com.ieschabas.sportshub.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamDao: TeamDao,
    private val playerDao: PlayerDao
) : TeamRepository {

    override fun observeTeams(): Flow<List<Team>> =
        teamDao.observeTeams()
            .map { list -> list.map { it.toDomain() } }

    override fun observeTeam(id: String): Flow<Team?> =
        teamDao.observeTeam(id).map { it?.toDomain() }

    override suspend fun getTeam(id: String): Team? =
        teamDao.getTeam(id)?.toDomain()

    override suspend fun getPlayersByTeam(teamId: String): List<PlayerEntity> =
        playerDao.getPlayersByTeam(teamId)
}