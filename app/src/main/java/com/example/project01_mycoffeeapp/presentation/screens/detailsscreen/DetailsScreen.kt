package com.example.project01_mycoffeeapp.presentation.screens.detailsscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.project01_mycoffeeapp.R
import com.example.project01_mycoffeeapp.domain.model.Product

@Composable
fun DetailsScreen(productId: Int, navController: NavController) {

    val products = listOf(
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
        Product(
            id = 4,
            name = "Mocha",
            description = "With cocoa flavor",
            price = 9.80,
            R.drawable.coffee_4
        ),
        Product(
            id = 5,
            name = "Macchitato",
            description = "Bold and milky",
            price = 2.80,
            R.drawable.coffee_5
        ),
        Product(
            id = 6,
            name = "Flat White",
            description = "Refreshing and Rich",
            price = 6.80,
            R.drawable.coffee_6
        ),
    )

    val selectedProduct = products.find { it.id == productId }

    if(selectedProduct == null){
        Text("Product not found!", color = Color.Red)
        return
    }

    Scaffold(
        topBar = { DetailsScreenTopAppBar(navController) },
        bottomBar = { DetailsScreenBottomBar() }
    ) { innerPadding ->
        LazyColumn {
            item {
                ProductDetailsContent(
                    selectedProduct,
                    innerPadding
                )
            }
        }

    }
}