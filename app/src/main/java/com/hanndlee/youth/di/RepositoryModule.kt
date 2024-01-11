package com.hanndlee.youth.di

import com.hanndlee.youth.stores.data.repository.ProductsRepositoryImpl
import com.hanndlee.youth.stores.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProductRepository(
        impl: ProductsRepositoryImpl
    ): ProductsRepository
}
