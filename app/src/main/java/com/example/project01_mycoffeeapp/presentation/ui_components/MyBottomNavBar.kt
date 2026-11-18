package com.example.project01_mycoffeeapp.presentation.ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.project01_mycoffeeapp.R
import com.example.project01_mycoffeeapp.presentation.navigation.Route
import com.example.project01_mycoffeeapp.presentation.theme.LightBrown

@Composable
fun MyBottomNavBar(navController: NavController, routes: String) {
    // bottom nav items
    val navItems = listOf(
        NavItem("Home", R.drawable.regular_outline_home, Route.HomeScreen),
        NavItem("Cart", R.drawable.regular_outline_bag, Route.CartScreen),
        NavItem("Favourites", R.drawable.regular_outline_heart, Route.FavouritesScreen),
        NavItem("Profile", R.drawable.outline_account_circle_24, Route.ProfileScreen)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)
    ){
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title
                    )
                },
                modifier = Modifier.size(30.dp),
                onClick = {
                    navController.navigate(item.routes){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selected = item.title == routes,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    indicatorColor = LightBrown.copy(alpha = 0.03f),
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray
                )
            )
        }
    }
}

data class NavItem(
    val title : String,
    val icon : Int,
    val routes: Route
)