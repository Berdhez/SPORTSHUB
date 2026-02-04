package com.ieschabas.sportshub.domain.repository

import com.ieschabas.sportshub.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {

    fun observePlayers(): Flow<List<Player>>

    suspend fun getPlayer(id: String): Player?
}
