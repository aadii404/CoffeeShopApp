package com.example.project01_mycoffeeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.project01_mycoffeeapp.presentation.screens.cartscreen.CartScreen
import com.example.project01_mycoffeeapp.presentation.screens.detailsscreen.DetailsScreen
import com.example.project01_mycoffeeapp.presentation.screens.favouritescreen.FavoriteScreen
import com.example.project01_mycoffeeapp.presentation.screens.homescreen.HomeScreen
import com.example.project01_mycoffeeapp.presentation.screens.profilescreen.ProfileScreen
import com.example.project01_mycoffeeapp.presentation.screens.welcomescreen.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.WelcomeScreen) {
        composable<Route.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<Route.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Route.DetailsScreen> {backStackEntry ->
            val args = backStackEntry.toRoute<Route.DetailsScreen>()
            DetailsScreen(productId = args.productId, navController)
        }

        composable < Route.CartScreen> {
            CartScreen(navController)
        }

        composable < Route.FavouritesScreen> {
            FavoriteScreen(navController)
        }

        composable <Route.ProfileScreen>{
            ProfileScreen(navController)
        }
    }
}