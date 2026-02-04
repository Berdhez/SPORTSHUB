package com.ieschabas.sportshub.data.repository

import com.ieschabas.sportshub.data.local.database.dao.UserDao
import com.ieschabas.sportshub.data.local.mapper.toDomain
import com.ieschabas.sportshub.domain.model.User
import com.ieschabas.sportshub.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {

    override fun observeUsers(): Flow<List<User>> =
        userDao.observeUsers()
            .map { list -> list.map { it.toDomain() } }

    override suspend fun getUser(id: String): User? =
        userDao.getUser(id)?.toDomain()
}
