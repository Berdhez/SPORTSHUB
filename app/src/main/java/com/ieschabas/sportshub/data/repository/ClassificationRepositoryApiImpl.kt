package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.remote.SportsHubApi
import com.ieschabas.sportshub.data.remote.dto.toDomain
import com.ieschabas.sportshub.di.DataSourceApi
import com.ieschabas.sportshub.domain.model.Classification
import com.ieschabas.sportshub.domain.repository.ClassificationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@DataSourceApi
class ClassificationRepositoryApiImpl @Inject constructor(
    private val api: SportsHubApi
) : ClassificationRepository {

    override fun observeClassifications(): Flow<List<Classification>> = flow {
        emit(api.getClassifications().map { it.toDomain() })
    }

    override fun observeClassificationsByLeague(leagueId: String): Flow<List<Classification>> = flow {
        emit(api.getClassificationsByLeague(leagueId).map { it.toDomain() })
    }

    override suspend fun getClassification(id: String): Classification? =
        runCatching { api.getClassification(id).toDomain() }.getOrNull()

    override fun observeClassificationForTeam(teamId: String): Flow<Classification?> = flow {
        emit(api.getClassifications().firstOrNull { it.teamId == teamId }?.toDomain())
    }
}
