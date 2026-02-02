package com.ieschabas.sportshub.domain.repository

import com.ieschabas.sportshub.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun observeUsers(): Flow<User?>
    suspend fun getUser(id: String): User?


}