package com.ieschabas.sportshub.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ieschabas.sportshub.data.local.dao.ClassificationDao
import com.ieschabas.sportshub.data.local.dao.ClubDao
import com.ieschabas.sportshub.data.local.dao.LeagueDao
import com.ieschabas.sportshub.data.local.dao.MatchDao
import com.ieschabas.sportshub.data.local.dao.PlayerDao
import com.ieschabas.sportshub.data.local.dao.TeamDao
import com.ieschabas.sportshub.data.local.dao.UserDao
import com.ieschabas.sportshub.data.local.entities.ClassificationEntity
import com.ieschabas.sportshub.data.local.entities.ClubEntity
import com.ieschabas.sportshub.data.local.entities.LeagueEntity
import com.ieschabas.sportshub.data.local.entities.MatchEntity
import com.ieschabas.sportshub.data.local.entities.PlayerEntity
import com.ieschabas.sportshub.data.local.entities.TeamEntity
import com.ieschabas.sportshub.data.local.entities.UserEntity

@Database(
    entities = [ClassificationEntity::class,
        ClubEntity::class,
        LeagueEntity::class,
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
    abstract fun leagueDao(): LeagueDao
    abstract fun clubDao(): ClubDao

}
