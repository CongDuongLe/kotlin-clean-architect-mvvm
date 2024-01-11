package com.hanndlee.youth.stores.presentation.screens.product_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.hanndlee.youth.stores.domain.model.Product

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = "product image",
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillBounds,
                imageLoader = ImageLoader(LocalContext.current)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.title, style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)
        }

    }
}