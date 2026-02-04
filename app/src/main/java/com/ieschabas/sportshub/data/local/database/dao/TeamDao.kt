package com.ieschabas.sportshub.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ieschabas.sportshub.data.local.entities.TeamEntity
import com.ieschabas.sportshub.domain.model.Team
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {

    @Query("SELECT * FROM team")
    fun observeTeams(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM team WHERE id = :id LIMIT 1")
    suspend fun getTeam(id: String): TeamEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(teams: List<TeamEntity>)
}
