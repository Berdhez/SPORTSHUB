package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.local.dao.ClubDao
import com.ieschabas.sportshub.data.local.mapper.toDomain
import com.ieschabas.sportshub.domain.model.Club
import com.ieschabas.sportshub.domain.repository.ClubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ClubRepositoryImpl @Inject constructor(
    private val clubDao: ClubDao
) : ClubRepository {

    override fun observeClubs(): Flow<List<Club>> =
        clubDao.observeClubs()
            .map { entities -> entities.map { it.toDomain() } }

    override suspend fun getClub(id: String): Club? =
        clubDao.getClub(id)?.toDomain()
}

