package com.ieschabas.sportshub.domain.repository

import com.ieschabas.sportshub.domain.model.Classification
import kotlinx.coroutines.flow.Flow

interface ClassificationRepository {
    fun observeClassifications(): Flow<List<Classification>>
    suspend fun getClassification(id: String): Classification?

}
