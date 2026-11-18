package com.example.project01_mycoffeeapp.presentation.screens.favouritescreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project01_mycoffeeapp.R
import com.example.project01_mycoffeeapp.domain.model.Product
import com.example.project01_mycoffeeapp.presentation.ui_components.MyBottomNavBar

@Composable
fun FavoriteScreen(navController: NavController) {

    var favouriteItems by remember {
        mutableStateOf(
            listOf(
                Product(
                    id = 1,
                    name = "Epresso",
                    description = "Strong and Rich",
                    price = 4.80,
                    R.drawable.coffee_1
                ),
                Product(
                    id = 2,
                    name = "Latte",
                    description = "Smooth and Creamy",
                    price = 5.80,
                    R.drawable.coffee_2
                ),
                Product(
                    id = 3,
                    name = "Cappuccino",
                    description = "With Chocolate",
                    price = 8.80,
                    R.drawable.coffee_3
                ),
            )
        )
    }

    Scaffold(
        topBar = { FavouriteScreenTopAppBar() },
        bottomBar = { MyBottomNavBar(navController = navController, "Favourites") }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item {
                favouriteItems.forEach { product ->
                    FavouriteItemCart(
                        product,
                        onRemove = { favouriteItems = favouriteItems - product }
                    )
                }
            }
        }
    }
}