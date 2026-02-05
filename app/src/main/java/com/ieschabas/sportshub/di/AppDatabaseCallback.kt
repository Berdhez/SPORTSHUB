package com.ieschabas.sportshub.di

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ieschabas.sportshub.data.local.SampleData
import com.ieschabas.sportshub.data.local.SportsHubDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppDatabaseCallback(
    private val scope: CoroutineScope,
    private val dbProvider: () -> SportsHubDatabase
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        scope.launch(Dispatchers.IO) {
            val database = dbProvider()
            val payload = SampleData.create()

//            database.clubDao().insertAlL(payload.clubs)
//            database.classificationDao().insertAll(payload.classifications)
//            database.leagueDao().insertAll(payload.leagues)
            database.teamDao().insertAll(payload.teams)
            database.playerDao().insertAll(payload.players)
            database.matchDao().insertAll(payload.matches)
            database.userDao().upsert(payload.user)
//            payload.favorites.forEach { database.userDao().addFavouriteTeam(it) }
        }
    }
}
