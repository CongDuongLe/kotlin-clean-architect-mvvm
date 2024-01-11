package com.hanndlee.youth.stores.data.remote

import com.hanndlee.youth.stores.domain.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): List<Product>


}