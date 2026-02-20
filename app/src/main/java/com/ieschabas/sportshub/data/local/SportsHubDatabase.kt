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

@Database(
    entities = [ClassificationEntity::class,
        ClubEntity::class,
        LeagueEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SportsHubDatabase : RoomDatabase() {
    abstract fun classificationDao(): ClassificationDao
//    abstract fun teamDao(): TeamDao
//    abstract fun playerDao(): PlayerDao
    abstract fun leagueDao(): LeagueDao
//    abstract fun userDao(): UserDao
//    abstract fun matchDao(): MatchDao
    abstract fun clubDao(): ClubDao
//
}
