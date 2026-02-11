package com.ieschabas.sportshub.di

import android.content.Context
import androidx.room.Room
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import com.ieschabas.sportshub.data.local.SportsHubDatabase
import com.ieschabas.sportshub.data.local.database.dao.ClassificationDao
import com.ieschabas.sportshub.data.local.database.dao.MatchDao
import com.ieschabas.sportshub.data.local.database.dao.PlayerDao
import com.ieschabas.sportshub.data.local.database.dao.TeamDao
import com.ieschabas.sportshub.data.local.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): SportsHubDatabase =
        Room.databaseBuilder(context, SportsHubDatabase::class.java, "sportshub.db")
            .build()

    // Proveer DAOs
    @Provides
    fun provideClassificationDao(db: SportsHubDatabase): ClassificationDao = db.classificationDao()

    @Provides
    fun provideMatchDao(db: SportsHubDatabase): MatchDao = db.matchDao()

    @Provides
    fun providePlayerDao(db: SportsHubDatabase): PlayerDao = db.playerDao()

    @Provides
    fun provideTeamDao(db: SportsHubDatabase): TeamDao = db.teamDao()

    @Provides
    fun provideUserDao(db: SportsHubDatabase): UserDao = db.userDao()
}
