package com.hanndlee.youth.stores.domain.model

import com.squareup.moshi.Json

data class Product(
    @Json(name = "category") val category: String,
    @Json(name = "description") val description: String,
    @Json(name = "id") val id: Int,
    @Json(name = "image") val image: String,
    @Json(name = "price") val price: Double,
    @Json(name = "rating") val rating: Rating,
    @Json(name = "title") val title: String
)

data class Rating(
    @Json(name = "count") val count: Int,
    @Json(name = "rate") val rate: Double
)
