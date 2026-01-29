package com.ieschabas.sportshub.di

import android.content.Context
import androidx.room.Room
import com.ieschabas.sportshub.data.local.SportsHubDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): SportsHubDatabase =
        Room.databaseBuilder(context, SportsHubDatabase::class.java, "sportshub.db")
            .build()

    @Provides
    fun provideClassificationDao(db: SportsHubDatabase) = db.classificationDao()
}
