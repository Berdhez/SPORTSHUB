package com.ieschabas.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player")
    fun observePlayers(): Flow<List<PlayerEntity>>

    @Query("SELECT * FROM player WHERE teamId = :teamId")
    fun observePlayersByTeam(teamId: String): Flow<List<PlayerEntity>>

    @Query("SELECT * FROM player WHERE id = :id LIMIT 1")
    suspend fun getPlayer(id: String): PlayerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(players: List<PlayerEntity>)
    @Query("SELECT * FROM Player WHERE teamId = :teamId")
    suspend fun getPlayersByTeam(teamId: String): List<PlayerEntity>
}
