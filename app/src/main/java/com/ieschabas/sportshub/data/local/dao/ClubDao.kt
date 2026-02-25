package com.ieschabas.sportshub.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ieschabas.sportshub.data.local.entities.ClubEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ClubDao {

    @Query("SELECT * FROM club")
    fun observeClubs(): Flow<List<ClubEntity>>

    @Query("SELECT * FROM club WHERE id = :id LIMIT 1")
    suspend fun getClub(id: String): ClubEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<ClubEntity>)
}