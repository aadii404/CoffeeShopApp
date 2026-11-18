package com.example.project01_mycoffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.project01_mycoffeeapp.presentation.navigation.NavGraph
import com.example.project01_mycoffeeapp.presentation.screens.cartscreen.CartScreen
import com.example.project01_mycoffeeapp.presentation.screens.detailsscreen.DetailsScreen
import com.example.project01_mycoffeeapp.presentation.screens.detailsscreen.DetailsScreenTopAppBar
import com.example.project01_mycoffeeapp.presentation.screens.favouritescreen.FavoriteScreen
import com.example.project01_mycoffeeapp.presentation.screens.homescreen.HomeScreen
import com.example.project01_mycoffeeapp.presentation.screens.profilescreen.ProfileScreen
import com.example.project01_mycoffeeapp.presentation.theme.Project01_MyCoffeeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project01_MyCoffeeAppTheme {
                NavGraph()
            }
        }
    }
}

