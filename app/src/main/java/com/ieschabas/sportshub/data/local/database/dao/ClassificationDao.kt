package com.ieschabas.sportshub.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ieschabas.sportshub.data.local.entities.ClassificationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClassificationDao {

    @Query("SELECT * FROM classification ORDER BY totalPoints DESC")
    fun observeClassifications(): Flow<List<ClassificationEntity>>

    @Query("SELECT * FROM classification WHERE id = :id LIMIT 1")
    suspend fun getClassification(id: String): ClassificationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<ClassificationEntity>)
}
