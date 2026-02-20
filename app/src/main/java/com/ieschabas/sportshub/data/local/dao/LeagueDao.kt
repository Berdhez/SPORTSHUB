package com.ieschabas.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ieschabas.sportshub.data.local.entities.LeagueEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LeagueDao {

    @Query("SELECT * FROM league")
    fun observeLeagues(): Flow<List<LeagueEntity>>

    @Query("SELECT * FROM league WHERE id = :id LIMIT 1")
    suspend fun getLeagueById(id: String): LeagueEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<LeagueEntity>)
}