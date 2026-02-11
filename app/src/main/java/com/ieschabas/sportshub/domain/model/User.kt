package com.ieschabas.sportshub.domain.model

data class User(
    val id : String,
    val fullName : String,
    val username: String ,
    val email : String,
    val memberSince : String,
    val verified: Boolean
)
