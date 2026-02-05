package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.local.database.dao.ClassificationDao
import com.ieschabas.sportshub.data.local.mapper.toDomain
import com.ieschabas.sportshub.domain.model.Classification
import com.ieschabas.sportshub.domain.repository.ClassificationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class ClassificationRepositoryImpl @Inject constructor(
    private val classificationDao: ClassificationDao
) : ClassificationRepository {

    override fun observeClassifications(): Flow<List<Classification>> =
        classificationDao.observeClassifications()
            .map { list -> list.map { it.toDomain() } }

    override suspend fun getClassification(id: String): Classification? =
        classificationDao.getClassification(id)?.toDomain()
}

