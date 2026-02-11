package com.ieschabas.sportshub.domain.repository

import com.ieschabas.sportshub.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface MatchRepository {

    fun observeMatches(): Flow<List<Match>>

    suspend fun getMatch(id: String): Match?
}
