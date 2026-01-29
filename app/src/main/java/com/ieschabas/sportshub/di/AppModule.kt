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
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.jvm.java


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDb(
        @ApplicationContext context: Context
    ): SportsHubDatabase {

        lateinit var instance: SportsHubDatabase

        instance = Room.databaseBuilder(
            context,
            SportsHubDatabase::class.java,
            "sportshub.db"
        )
            .addCallback(
                AppDatabaseCallback(
                    scope = CoroutineScope(SupervisorJob() + Dispatchers.IO),
                    dbProvider = { instance }
                )
            )
            .build()

        return instance
    }

    @Provides
    fun provideLeagueDao(db: SportsHubDatabase): LeagueDao = db.leagueDao()

    @Provides
    fun provideTeamDao(db: SportsHubDatabase): TeamDao = db.teamDao()

    @Provides
    fun provideUserDao(db: SportsHubDatabase): UserDao = db.userDao()


    @Provides
    fun provideMatchDao(db: SportsHubDatabase): MatchDao = db.matchDao()


    @Provides
    fun providePlayerDao(db: SportsHubDatabase): PlayerDao = db.playerDao()

    @Provides
    fun provideClubDao(db: SportsHubDatabase): ClubDao = db.clubDao()


    @Provides
    fun provideClassificationDao(db: SportsHubDatabase): ClassificationDao = db.classificationDao()

}

