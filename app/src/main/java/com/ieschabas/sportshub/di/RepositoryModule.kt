package com.ieschabas.sportshub.di

import com.ieschabas.sportshub.BuildConfig
import com.ieschabas.sportshub.data.local.dao.ClassificationDao
import com.ieschabas.sportshub.data.local.dao.ClubDao
import com.ieschabas.sportshub.data.local.dao.LeagueDao
import com.ieschabas.sportshub.data.local.dao.MatchDao
import com.ieschabas.sportshub.data.local.dao.PlayerDao
import com.ieschabas.sportshub.data.local.dao.TeamDao
import com.ieschabas.sportshub.data.local.dao.UserDao
import com.ieschabas.sportshub.data.remote.SportsHubApi
import com.ieschabas.sportshub.data.repository.ClassificationRepositoryApiImpl
import com.ieschabas.sportshub.data.repository.ClassificationRepositoryImpl
import com.ieschabas.sportshub.data.repository.ClubRepositoryImpl
import com.ieschabas.sportshub.data.repository.LeagueRepositoryApiImpl
import com.ieschabas.sportshub.data.repository.LeagueRepositoryImpl
import com.ieschabas.sportshub.data.repository.MatchRepositoryApiImpl
import com.ieschabas.sportshub.data.repository.MatchRepositoryImpl
import com.ieschabas.sportshub.data.repository.PlayerRepositoryApiImpl
import com.ieschabas.sportshub.data.repository.PlayerRepositoryImpl
import com.ieschabas.sportshub.data.repository.TeamRepositoryApiImpl
import com.ieschabas.sportshub.data.repository.TeamRepositoryImpl
import com.ieschabas.sportshub.data.repository.UserRepositoryImpl
import com.ieschabas.sportshub.domain.repository.ClassificationRepository
import com.ieschabas.sportshub.domain.repository.ClubRepository
import com.ieschabas.sportshub.domain.repository.LeagueRepository
import com.ieschabas.sportshub.domain.repository.MatchRepository
import com.ieschabas.sportshub.domain.repository.PlayerRepository
import com.ieschabas.sportshub.domain.repository.TeamRepository
import com.ieschabas.sportshub.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    // ════════════════════════════════════════════════════════════════════
    // Qualified Room implementations
    // ════════════════════════════════════════════════════════════════════

    @Provides @Singleton @DataSourceRoom
    fun provideClassificationRoomImpl(dao: ClassificationDao): ClassificationRepositoryImpl =
        ClassificationRepositoryImpl(dao)

    @Provides @Singleton @DataSourceRoom
    fun provideLeagueRoomImpl(dao: LeagueDao): LeagueRepositoryImpl =
        LeagueRepositoryImpl(dao)

    @Provides @Singleton @DataSourceRoom
    fun provideMatchRoomImpl(dao: MatchDao): MatchRepositoryImpl =
        MatchRepositoryImpl(dao)

    @Provides @Singleton @DataSourceRoom
    fun provideTeamRoomImpl(teamDao: TeamDao, playerDao: PlayerDao): TeamRepositoryImpl =
        TeamRepositoryImpl(teamDao, playerDao)

    @Provides @Singleton @DataSourceRoom
    fun providePlayerRoomImpl(dao: PlayerDao): PlayerRepositoryImpl =
        PlayerRepositoryImpl(dao)

    // ════════════════════════════════════════════════════════════════════
    // Qualified API implementations
    // ════════════════════════════════════════════════════════════════════

    @Provides @Singleton @DataSourceApi
    fun provideClassificationApiImpl(api: SportsHubApi): ClassificationRepositoryApiImpl =
        ClassificationRepositoryApiImpl(api)

    @Provides @Singleton @DataSourceApi
    fun provideLeagueApiImpl(api: SportsHubApi): LeagueRepositoryApiImpl =
        LeagueRepositoryApiImpl(api)

    @Provides @Singleton @DataSourceApi
    fun provideMatchApiImpl(api: SportsHubApi): MatchRepositoryApiImpl =
        MatchRepositoryApiImpl(api)

    @Provides @Singleton @DataSourceApi
    fun provideTeamApiImpl(api: SportsHubApi): TeamRepositoryApiImpl =
        TeamRepositoryApiImpl(api)

    @Provides @Singleton @DataSourceApi
    fun providePlayerApiImpl(api: SportsHubApi): PlayerRepositoryApiImpl =
        PlayerRepositoryApiImpl(api)

    // ════════════════════════════════════════════════════════════════════
    // Interface bindings — selects Room or API based on BuildConfig.USE_API
    // ════════════════════════════════════════════════════════════════════

    @Provides @Singleton
    fun provideClassificationRepository(
        @DataSourceRoom roomImpl: ClassificationRepositoryImpl,
        @DataSourceApi  apiImpl:  ClassificationRepositoryApiImpl,
    ): ClassificationRepository = if (BuildConfig.USE_API) apiImpl else roomImpl

    @Provides @Singleton
    fun provideLeagueRepository(
        @DataSourceRoom roomImpl: LeagueRepositoryImpl,
        @DataSourceApi  apiImpl:  LeagueRepositoryApiImpl,
    ): LeagueRepository = if (BuildConfig.USE_API) apiImpl else roomImpl

    @Provides @Singleton
    fun provideMatchRepository(
        @DataSourceRoom roomImpl: MatchRepositoryImpl,
        @DataSourceApi  apiImpl:  MatchRepositoryApiImpl,
    ): MatchRepository = if (BuildConfig.USE_API) apiImpl else roomImpl

    @Provides @Singleton
    fun provideTeamRepository(
        @DataSourceRoom roomImpl: TeamRepositoryImpl,
        @DataSourceApi  apiImpl:  TeamRepositoryApiImpl,
    ): TeamRepository = if (BuildConfig.USE_API) apiImpl else roomImpl

    @Provides @Singleton
    fun providePlayerRepository(
        @DataSourceRoom roomImpl: PlayerRepositoryImpl,
        @DataSourceApi  apiImpl:  PlayerRepositoryApiImpl,
    ): PlayerRepository = if (BuildConfig.USE_API) apiImpl else roomImpl

    // ════════════════════════════════════════════════════════════════════
    // Repositories with a single implementation (no qualifier needed)
    // ════════════════════════════════════════════════════════════════════

    @Provides @Singleton
    fun provideUserRepository(
        userDao: UserDao,
    ): UserRepository = UserRepositoryImpl(userDao)

    @Provides @Singleton
    fun provideClubRepository(
        clubDao: ClubDao,
    ): ClubRepository = ClubRepositoryImpl(clubDao)
}
