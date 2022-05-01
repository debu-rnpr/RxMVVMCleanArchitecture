package com.mvrx.data.di.module

import com.mvrx.data.api.ApiService
import com.mvrx.data.repository.CatRepositoryImpl
import com.mvrx.domain.repository.CatRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    internal fun provideCatRepository(
        retrofit: Retrofit
    ): CatRepository =
        CatRepositoryImpl(apiService = retrofit.create(ApiService::class.java))
}