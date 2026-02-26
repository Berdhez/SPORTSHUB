package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.remote.SportsHubApi
import com.ieschabas.sportshub.data.remote.dto.toDomain
import com.ieschabas.sportshub.di.DataSourceApi
import com.ieschabas.sportshub.domain.model.League
import com.ieschabas.sportshub.domain.repository.LeagueRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@DataSourceApi
class LeagueRepositoryApiImpl @Inject constructor(
    private val api: SportsHubApi
) : LeagueRepository {

    override fun observeLeagues(): Flow<List<League>> = flow {
        emit(api.getLeagues().map { it.toDomain() })
    }

    override suspend fun getLeague(id: String): League? =
        runCatching { api.getLeague(id).toDomain() }.getOrNull()
}
