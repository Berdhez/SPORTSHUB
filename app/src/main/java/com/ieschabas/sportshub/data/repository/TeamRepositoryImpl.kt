package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.local.database.dao.TeamDao
import com.ieschabas.sportshub.data.local.mapper.toDomain
import com.ieschabas.sportshub.domain.model.Team
import com.ieschabas.sportshub.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamDao: TeamDao
) : TeamRepository {

    override fun observeTeams(): Flow<List<Team>> =
        teamDao.observeTeams()
            .map { list -> list.map { it.toDomain() } }

    override suspend fun getTeam(id: String): Team? =
        teamDao.getTeam(id)?.toDomain()
}
