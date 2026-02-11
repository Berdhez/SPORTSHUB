package com.ieschabas.sportshub.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ieschabas.sportshub.data.local.dao.ClassificationDao
import com.ieschabas.sportshub.data.local.database.dao.MatchDao
import com.ieschabas.sportshub.data.local.database.dao.PlayerDao
import com.ieschabas.sportshub.data.local.database.dao.TeamDao
import com.ieschabas.sportshub.data.local.database.dao.UserDao
import com.ieschabas.sportshub.data.local.entities.ClassificationEntity
import com.ieschabas.sportshub.data.local.entities.MatchEntity
import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import com.ieschabas.sportshub.data.local.entities.TeamEntity
import com.ieschabas.sportshub.data.local.entities.UserEntity

@Database(
    entities = [ClassificationEntity::class,
        MatchEntity::class,
        PlayerEntity::class,
        TeamEntity::class,
        UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SportsHubDatabase : RoomDatabase() {
    abstract fun matchDao(): MatchDao
    abstract fun playerDao(): PlayerDao
    abstract fun teamDao(): TeamDao
    abstract fun userDao(): UserDao
    abstract fun classificationDao(): ClassificationDao
}
