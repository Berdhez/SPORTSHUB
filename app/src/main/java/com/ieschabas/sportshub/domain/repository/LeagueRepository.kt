package com.ieschabas.sportshub.domain.repository

import com.ieschabas.sportshub.domain.model.League
import kotlinx.coroutines.flow.Flow

interface LeagueRepository {
    fun observeLeagues(): Flow<List<League>>
    suspend fun getLeague(id: String): League?
}