package com.ieschabas.sportshub.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ieschabas.sportshub.data.local.dao.ClassificationDao
import com.ieschabas.sportshub.data.local.entities.ClassificationEntity

@Database(
    entities = [ClassificationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SportsHubDatabase : RoomDatabase() {
    abstract fun classificationDao(): ClassificationDao
}
