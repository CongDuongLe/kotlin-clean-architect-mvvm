package com.hanndlee.youth.stores.presentation.screens.product_screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.hanndlee.youth.stores.presentation.components.Topbar
import com.hanndlee.youth.stores.presentation.screens.product_screen.components.ProductCard
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun ProductScreen(
    navController: NavHostController,
    viewModel: ProductViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    ProductContent(
        state = state
    )
}

@Composable
fun ProductContent(
    state: ProductViewState
) {
    Log.i("state", "ProductContent:$state ")


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        topBar = {
            Topbar(
                title = "Product",
                navigationAction = {
                    // open drawer
                },
                navigationIcon = {
                     Icon(
                         imageVector = Icons.Default.Menu, contentDescription = "menu"
                     )
                }
            )
        }
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.padding(top= it.calculateTopPadding()),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalItemSpacing = 6.dp,
        ){
            items(state.products) { product ->
                ProductCard(product = product)
            }
        }
    }
}
