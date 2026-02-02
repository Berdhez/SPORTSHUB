package com.ieschabas.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    // Obtener todos los jugadores de un equipo concreto
    @Query("SELECT * FROM player WHERE teamId = :teamId ORDER BY name ASC")
    fun getPlayersByTeam(teamId: Int): Flow<List<com.google.android.gms.games.PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayers(players: List<com.google.android.gms.games.PlayerEntity>)

    @Query("DELETE FROM player WHERE teamId = :teamId")
    suspend fun deletePlayersByTeam(teamId: Int)
}