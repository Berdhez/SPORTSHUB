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
    fun getAllLeagues(): Flow<List<LeagueEntity>>

    @Query("SELECT * FROM league WHERE id = :leagueId")
    suspend fun getLeagueById(leagueId: Int): LeagueEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeagues(leagues: List<LeagueEntity>): List<Long>

    @Update
    suspend fun updateLeague(league: LeagueEntity): Int
}