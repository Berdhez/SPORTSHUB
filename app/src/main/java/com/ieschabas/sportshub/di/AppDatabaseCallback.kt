package com.ieschabas.sportshub.di

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ieschabas.sportshub.data.local.SampleData
import com.ieschabas.sportshub.data.local.SportsHubDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class AppDatabaseCallback @Inject constructor(
    private val database: Provider<SportsHubDatabase>
) : RoomDatabase.Callback() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        applicationScope.launch {
            val payload = SampleData.create()
            database.get().leagueDao().upsertAll(payload.leagues)
            database.get().teamDao().insertAll(payload.teams)
            database.get().playerDao().insertAll(payload.players)
            database.get().matchDao().insertAll(payload.matches)
            database.get().classificationDao().upsertAll(payload.classifications)
            database.get().userDao().upsert(payload.user)
        }
    }
}
