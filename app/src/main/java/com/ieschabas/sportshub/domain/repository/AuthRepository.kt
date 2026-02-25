package com.ieschabas.sportshub.domain.repository

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser: FirebaseUser?
    fun isLoggedIn(): Boolean
    suspend fun login(email: String, password: String): Result<FirebaseUser>
    suspend fun register(email: String, password: String, displayName: String): Result<FirebaseUser>
    suspend fun logout()
}
