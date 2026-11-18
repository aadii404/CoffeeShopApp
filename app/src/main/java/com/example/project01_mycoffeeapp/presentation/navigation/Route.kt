package com.example.project01_mycoffeeapp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Route {

    @Serializable
    object WelcomeScreen : Route()

    @Serializable
    object HomeScreen : Route()

    @Serializable
    data class DetailsScreen(val productId: Int): Route()

    @Serializable
    object CartScreen: Route()

    @Serializable
    object FavouritesScreen: Route()

    @Serializable
    object ProfileScreen: Route()


}