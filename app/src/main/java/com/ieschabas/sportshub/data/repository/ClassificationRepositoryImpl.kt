package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.local.dao.ClassificationDao
import com.ieschabas.sportshub.data.local.mapper.toDomain
import com.ieschabas.sportshub.di.DataSourceRoom
import com.ieschabas.sportshub.domain.model.Classification
import com.ieschabas.sportshub.domain.repository.ClassificationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@DataSourceRoom
class ClassificationRepositoryImpl @Inject constructor(
    private val classificationDao: ClassificationDao
) : ClassificationRepository {


    override fun observeClassifications(): Flow<List<Classification>> =
        classificationDao.observeClassifications()
            .map { entities -> entities.map { it.toDomain() } }

    override fun observeClassificationsByLeague(leagueId: String): Flow<List<Classification>> =
        classificationDao.observeClassificationsByLeague(leagueId)
            .map { entities -> entities.map { it.toDomain() } }

    override suspend fun getClassification(id: String): Classification? =
        classificationDao.getClassification(id)?.toDomain()

    override fun observeClassificationForTeam(teamId: String): Flow<Classification?> =
        classificationDao.observeByTeam(teamId)
            .map { it?.toDomain() }

}