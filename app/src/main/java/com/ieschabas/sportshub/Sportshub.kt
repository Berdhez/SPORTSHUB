package com.ieschabas.sportshub

import android.app.Application
import com.ieschabas.sportshub.data.local.SampleData
import com.ieschabas.sportshub.data.local.SportsHubDatabase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class Sportshub : Application() {

    @Inject
    lateinit var database: SportsHubDatabase

    override fun onCreate() {
        super.onCreate()
        populateDatabase()
    }

    private fun populateDatabase() {
        // The database population should ideally happen only once when the DB is created,
        // using a RoomDatabase.Callback. However, this approach will also work to get
        // the sample data loaded. Since we use REPLACE and Upsert strategies, running
        // this on every app start won't cause crashes, but it's not optimal.
        CoroutineScope(Dispatchers.IO).launch {
            val sample = SampleData.create()
            with(database) {
                teamDao().insertAll(sample.teams)
                playerDao().insertAll(sample.players)
                matchDao().insertAll(sample.matches)
                classificationDao().upsertAll(sample.classifications)
                userDao().upsert(sample.user)
            }
        }
    }
}