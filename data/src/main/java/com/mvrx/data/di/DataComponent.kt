package com.mvrx.data.di

import android.content.Context
import com.mvrx.data.di.module.NetworkModule
import com.mvrx.data.di.module.RepositoryModule
import com.mvrx.domain.repository.CatRepository
import dagger.BindsInstance
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface DataComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DataComponent
    }

    // Exposed to sub-graphs
    fun provideCatRepository(): CatRepository
}