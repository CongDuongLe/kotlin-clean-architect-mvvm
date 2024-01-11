package com.hanndlee.youth.stores.data.repository

import arrow.core.Either
import com.hanndlee.youth.stores.data.mapper.toGeneralError
import com.hanndlee.youth.stores.data.remote.ProductApi
import com.hanndlee.youth.stores.domain.model.NetworkError
import com.hanndlee.youth.stores.domain.model.Product
import com.hanndlee.youth.stores.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productApi: ProductApi
) : ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productApi.getProducts()
        }.mapLeft { it.toGeneralError() }

    }
}
