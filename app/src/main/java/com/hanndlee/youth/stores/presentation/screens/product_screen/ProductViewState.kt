package com.hanndlee.youth.stores.presentation.screens.product_screen

import com.hanndlee.youth.stores.domain.model.Product

data class ProductViewState(
    val isLoading : Boolean = false,
    val products : List<Product> = emptyList(),
    val error : String? = null
)
