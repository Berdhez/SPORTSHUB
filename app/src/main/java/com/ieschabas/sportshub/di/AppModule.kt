package com.ieschabas.sportshub.di

import android.content.Context
import androidx.room.Room
import com.ieschabas.sportshub.data.local.dao.ClassificationDao
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
    ): AppDatabase {

        lateinit var instance: AppDatabase

        instance = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
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
    fun provideLeagueDao(db: AppDatabase): LeagueDao = db.leagueDao()

    @Provides
    fun provideTeamDao(db: AppDatabase): TeamDao = db.teamDao()

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()


    @Provides
    fun provideMatchDao(db: AppDatabase): MatchDao = db.matchDao()


    @Provides
    fun providePlayerDao(db: AppDatabase): PlayerDao = db.playerDao()

    @Provides
    fun provideClubDao(db: AppDatabase): ClubDao = db.clubDao()


    @Provides
    fun provideClassificationDao(db: AppDatabase): ClassificationDao = db.classificationDao()

}

