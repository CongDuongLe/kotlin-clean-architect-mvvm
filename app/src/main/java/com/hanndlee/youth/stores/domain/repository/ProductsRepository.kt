package com.hanndlee.youth.stores.domain.repository

import arrow.core.Either
import com.hanndlee.youth.stores.domain.model.NetworkError
import com.hanndlee.youth.stores.domain.model.Product

interface ProductsRepository {

    suspend fun getProducts(): Either<NetworkError, List<Product>>

}