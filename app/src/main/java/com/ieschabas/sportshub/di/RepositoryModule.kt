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
}
