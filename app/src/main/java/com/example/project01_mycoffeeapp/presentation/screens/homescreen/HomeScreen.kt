package com.example.project01_mycoffeeapp.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project01_mycoffeeapp.R
import com.example.project01_mycoffeeapp.domain.model.Product
import com.example.project01_mycoffeeapp.presentation.ui_components.MyBottomNavBar

@Composable
fun HomeScreen(navController: NavController) {

    val location = "BH - 10 SLIET Longowal"
    Scaffold(
        bottomBar = { MyBottomNavBar(navController, "Home") }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f / 3f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF303030), Color(0xFF1F1F1F), Color(0xFF121212))
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {

            //Displaying Products
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

            ProductGrid(products = products , navController = navController) {
                Text(text = "Location", color = Color.Gray, fontSize = 16.sp)

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = location,
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Change Location",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                MySearchBar()

                Spacer(modifier = Modifier.height(40.dp))

                Image(
                    painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Home Banner"
                )

                Spacer(modifier = Modifier.height(10.dp))

                HomeScreenCategories()
            }
        }
    }
}