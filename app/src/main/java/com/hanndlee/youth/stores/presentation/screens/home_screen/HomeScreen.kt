package com.hanndlee.youth.stores.presentation.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {

    val snackbarHostState = remember { SnackbarHostState() }

    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
            )
        },

        topBar = {
            TopAppBar(
                title = { Text(text = "HomeScreen") },
                navigationIcon = {
                    IconButton(onClick = {
                        // open drawer
                        scope.launch {
                            snackbarHostState.showSnackbar("open drawer", actionLabel = "close", duration = SnackbarDuration.Short)
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu, contentDescription = "menu"
                        )
                    }

                }

            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Text(text = "HomeScreen")
        }
    }


}