package com.ieschabas.sportshub.di

import com.ieschabas.sportshub.data.repository.ClassificationRepositoryImpl
import com.ieschabas.sportshub.domain.repository.ClassificationRepository
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

//    @Binds
//    abstract fun bindUserRepository(
//        impl: UserRepositoryImpl
//    ): UserRepository
//
//    @Binds
//    abstract fun bindClubRepository(
//        impl: ClubRepositoryImpl
//    ): ClubRepository
//
//    @Binds
//    abstract fun bindTeamRepository(
//        impl: TeamRepositoryImpl
//    ): TeamRepository
//
//    @Binds
//    abstract fun bindPlayerRepository(
//        impl: PlayerRepositoryImpl
//    ): PlayerRepository
//
//    @Binds
//    abstract fun bindLeagueRepository(
//        impl: LeagueRepositoryImpl
//    ): LeagueRepository


}
