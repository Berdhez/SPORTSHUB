package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.local.database.dao.MatchDao
import com.ieschabas.sportshub.data.local.mapper.toDomain
import com.ieschabas.sportshub.domain.model.Match
import com.ieschabas.sportshub.domain.repository.MatchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchDao: MatchDao
) : MatchRepository {

    override fun observeMatches(): Flow<List<Match>> =
        matchDao.observeMatches()
            .map { list -> list.map { it.toDomain() } }

    override suspend fun getMatch(id: String): Match? =
        matchDao.getMatch(id)?.toDomain()
}
