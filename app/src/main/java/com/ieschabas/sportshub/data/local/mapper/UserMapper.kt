package com.ieschabas.sportshub.data.local.mapper

import com.ieschabas.sportshub.data.local.entities.UserEntity
import com.ieschabas.sportshub.domain.model.User

fun UserEntity.toDomain(): User =
    User(
        id = id,
        fullName = fullName,
        username = username,
        email = email,
        memberSince = memberSince,
        verified = verified
    )

fun User.toEntity(): UserEntity =
    UserEntity(
        id = id,
        fullName = fullName,
        username = username,
        email = email,
        memberSince = memberSince,
        verified = verified

    )