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

    @Query("SELECT * FROM club ORDER BY name ASC")
    fun getAllClubs(): Flow<List<ClubEntity>>

    @Query("SELECT * FROM club WHERE id = :clubId")
    suspend fun getClubById(clubId: Int): ClubEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(clubs: List<ClubEntity>): List<Long>

    @Delete
    suspend fun deleteClub(club: ClubEntity): Int

    @Query("SELECT COUNT(*) FROM club")
    suspend fun getClubCount(): Int
}