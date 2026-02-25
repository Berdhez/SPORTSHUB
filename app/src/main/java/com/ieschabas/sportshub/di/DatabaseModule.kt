package com.ieschabas.sportshub.di

import android.content.Context
import androidx.room.Room
import com.ieschabas.sportshub.data.local.SportsHubDatabase
import com.ieschabas.sportshub.data.local.dao.ClassificationDao
import com.ieschabas.sportshub.data.local.dao.ClubDao
import com.ieschabas.sportshub.data.local.dao.LeagueDao
import com.ieschabas.sportshub.data.local.dao.MatchDao
import com.ieschabas.sportshub.data.local.dao.PlayerDao
import com.ieschabas.sportshub.data.local.dao.TeamDao
import com.ieschabas.sportshub.data.local.dao.UserDao
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
    fun provideDb(
        @ApplicationContext context: Context,
        callback: AppDatabaseCallback
    ): SportsHubDatabase =
        Room.databaseBuilder(context, SportsHubDatabase::class.java, "sportshub.db")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()

    @Provides
    fun provideClassificationDao(db: SportsHubDatabase): ClassificationDao = db.classificationDao()

    @Provides
    fun provideLeagueDao(db: SportsHubDatabase): LeagueDao = db.leagueDao()

    @Provides
    fun provideClubDao(db: SportsHubDatabase): ClubDao = db.clubDao()

    @Provides
    fun provideMatchDao(db: SportsHubDatabase): MatchDao = db.matchDao()

    @Provides
    fun providePlayerDao(db: SportsHubDatabase): PlayerDao = db.playerDao()

    @Provides
    fun provideTeamDao(db: SportsHubDatabase): TeamDao = db.teamDao()

    @Provides
    fun provideUserDao(db: SportsHubDatabase): UserDao = db.userDao()
}