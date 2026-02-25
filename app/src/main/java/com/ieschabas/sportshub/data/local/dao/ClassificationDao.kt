package com.ieschabas.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ieschabas.sportshub.data.local.entities.ClassificationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClassificationDao {

    @Query("SELECT * FROM classifications ORDER BY totalPoints DESC")
    fun observeClassifications(): Flow<List<ClassificationEntity>>

    @Query("SELECT * FROM classifications WHERE leagueId = :leagueId ORDER BY totalPoints DESC")
    fun observeClassificationsByLeague(leagueId: String): Flow<List<ClassificationEntity>>

    @Query("SELECT * FROM classifications WHERE id = :id LIMIT 1")
    suspend fun getClassification(id: String): ClassificationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<ClassificationEntity>): List<Long>

    @Query("SELECT * FROM classifications WHERE teamId = :teamId LIMIT 1")
    fun observeByTeam(teamId: String): Flow<ClassificationEntity?>

}