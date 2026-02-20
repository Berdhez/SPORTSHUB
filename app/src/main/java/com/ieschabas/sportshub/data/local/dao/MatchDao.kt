package com.ieschabas.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ieschabas.sportshub.data.local.entities.MatchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {

    @Query("SELECT * FROM `match` ORDER BY dateUtc ASC")
    fun getAllMatches(): Flow<List<MatchEntity>>

    @Query("SELECT * FROM `match` WHERE dateUtc = :jornada")
    fun getMatchesByJornada(jornada: Int): Flow<List<MatchEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatches(matches: List<MatchEntity>): List<Long>

    @Update
    suspend fun updateMatchResult(match: MatchEntity): Int
}