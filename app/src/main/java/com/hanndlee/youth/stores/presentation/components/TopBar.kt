package com.hanndlee.youth.stores.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(
    title : String? = null,
    navigationAction : (() -> Unit)? = null,
    navigationIcon : @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            title?.let {
                Text(text = it)
            }
        },
        navigationIcon = {
            navigationAction?.let {
                IconButton(onClick = {
                    it.invoke()
                }) {
                    if (navigationIcon != null) {
                        navigationIcon()
                    }
                }
            }
        }

    )
}