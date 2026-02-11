package com.ieschabas.sportshub.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ieschabas.sportshub.data.local.entities.UserEntity
import com.ieschabas.sportshub.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun observeUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    suspend fun getUser(id: String): UserEntity?

    @Upsert
    suspend fun upsert(user: UserEntity)
}

