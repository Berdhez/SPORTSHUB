package com.ieschabas.sportshub.di

import com.ieschabas.sportshub.data.repository.ClassificationRepositoryImpl
import com.ieschabas.sportshub.data.repository.ClubRepositoryImpl
import com.ieschabas.sportshub.data.repository.LeagueRepositoryImpl
import com.ieschabas.sportshub.data.repository.UserRepositoryImpl
import com.ieschabas.sportshub.domain.repository.ClassificationRepository
import com.ieschabas.sportshub.domain.repository.ClubRepository
import com.ieschabas.sportshub.domain.repository.LeagueRepository
import com.ieschabas.sportshub.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindClassificationRepository(
        impl: ClassificationRepositoryImpl
    ): ClassificationRepository

    @Binds
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository

    @Binds
    abstract fun bindClubRepository(
        impl: ClubRepositoryImpl
    ): ClubRepository

    @Binds
    abstract fun bindLeagueRepository(
        impl: LeagueRepositoryImpl
    ): LeagueRepository



    @Binds
    @Singleton
    abstract fun bindMatchRepository(
        impl: MatchRepositoryImpl
    ): MatchRepository

    @Binds
    @Singleton
    abstract fun bindPlayerRepository(
        impl: PlayerRepositoryImpl
    ): PlayerRepository

    @Binds
    @Singleton
    abstract fun bindTeamRepository(
        impl: TeamRepositoryImpl
    ): TeamRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository
}
