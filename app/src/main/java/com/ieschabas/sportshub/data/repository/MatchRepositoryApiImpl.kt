package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.remote.SportsHubApi
import com.ieschabas.sportshub.data.remote.dto.toDomain
import com.ieschabas.sportshub.di.DataSourceApi
import com.ieschabas.sportshub.domain.model.Match
import com.ieschabas.sportshub.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@DataSourceApi
class MatchRepositoryApiImpl @Inject constructor(
    private val api: SportsHubApi
) : MatchRepository {

    override fun observeMatches(): Flow<List<Match>> = flow {
        emit(api.getMatches().map { it.toDomain() })
    }

    override suspend fun getMatch(id: String): Match? =
        runCatching { api.getMatch(id).toDomain() }.getOrNull()
}
