package com.onsenstamprallyapp.data.di

import com.onsenstamprallyapp.domain.repository.OnsenInfoRepository
import com.onsenstamprallyapp.data.repository.impl.OnsenInfoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    internal abstract fun bindOnsenInfoRepository(impl: OnsenInfoRepositoryImpl): OnsenInfoRepository
}