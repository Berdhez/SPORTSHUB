package com.ieschabas.sportshub.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ieschabas.sportshub.data.local.SampleData
import com.ieschabas.sportshub.data.local.SportsHubDatabase
import com.ieschabas.sportshub.data.local.dao.ClassificationDao
import com.ieschabas.sportshub.data.local.dao.MatchDao
import com.ieschabas.sportshub.data.local.dao.PlayerDao
import com.ieschabas.sportshub.data.local.dao.TeamDao
import com.ieschabas.sportshub.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDb(
        @ApplicationContext context: Context,
        callback: PrepopulateCallback
    ): SportsHubDatabase =
        Room.databaseBuilder(context, SportsHubDatabase::class.java, "sportshub.db")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
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

@Singleton
class PrepopulateCallback @Inject constructor(
    private val database: Provider<SportsHubDatabase>
) : RoomDatabase.Callback() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        applicationScope.launch {
            val sampleData = SampleData.create()
            database.get().matchDao().insertAll(sampleData.matches)
            database.get().teamDao().insertAll(sampleData.teams)
            database.get().playerDao().insertAll(sampleData.players)
            database.get().classificationDao().upsertAll(sampleData.classifications)
            database.get().userDao().upsert(sampleData.user)
        }
    }
}