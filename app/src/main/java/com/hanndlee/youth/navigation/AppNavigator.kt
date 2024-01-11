package com.hanndlee.youth.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hanndlee.youth.stores.presentation.screens.home_screen.HomeScreen
import com.hanndlee.youth.stores.presentation.screens.product_screen.ProductScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    val context = LocalContext.current

    val sharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE)

    val startDestination = if (sharedPreferences.getBoolean("isFirstTimeOpenApp", false)) {
        Screens.Onboarding.route
    } else {
        Screens.Product.route
    }


    NavHost(navController = navController, startDestination = startDestination ) {
        composable(Screens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screens.Product.route) {
            ProductScreen(navController = navController)
        }
    }


}
