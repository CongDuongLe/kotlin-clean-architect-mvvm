package com.hanndlee.youth.stores.presentation.screens.product_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanndlee.youth.stores.domain.repository.ProductsRepository
import com.hanndlee.youth.stores.presentation.sendEvent
import com.hanndlee.youth.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProductViewState())

    val state = _state.asStateFlow()

    init {
        getProducts()
    }


     fun getProducts() {
        viewModelScope.launch {
            // updating loading state
            _state.update {
                it.copy(isLoading = true)
            }
            // getting products from repository
            productsRepository.getProducts()
                .onRight { products ->
                    // updating state with products
                    _state.update {
                        it.copy(products = products)
                    }
                }.onLeft { error ->
                    // updating state with error
                    _state.update {
                        it.copy(error = error.error.mes)
                    }
                    sendEvent(Event.Toast(error.error.mes))
                } //
            // updating loading state
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}






