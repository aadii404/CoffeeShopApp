package com.example.project01_mycoffeeapp.presentation.screens.cartscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project01_mycoffeeapp.R
import com.example.project01_mycoffeeapp.domain.model.Product
import com.example.project01_mycoffeeapp.presentation.theme.LightBrown
import com.example.project01_mycoffeeapp.presentation.ui_components.MyBottomNavBar

@Composable
fun CartScreen(navController: NavController) {
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
    )

    val amount by remember { mutableStateOf(20.5) }
    val deliveryFee by remember { mutableStateOf(2.0) }
    val totalAmount by remember { mutableStateOf(amount + deliveryFee) }

    var expanded by remember { mutableStateOf(false) }
    val paymentMode = listOf("Debit Card", "Credit Card", "Online", "Cash on Delivery", "UPI")
    var selectedPaymentMode by remember { mutableStateOf(paymentMode[0]) }

    Scaffold(
        topBar = { CartScreenTopBar(navController) },
        bottomBar = {MyBottomNavBar(navController, "Cart")}
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item {
                Row() {
                    Text(
                        text = "Deliver",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold, color = LightBrown
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                products.forEach { product ->
                    CartItemCard(product)
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Payment Summery",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Price", fontSize = 18.sp)
                    Text(text = "$ $amount", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Delivery Fee", fontSize = 18.sp)
                    Text(text = "$ $deliveryFee", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.mobile_banking),
                                    contentDescription = "Payment Mode",
                                    modifier = Modifier.size(30.dp),
                                    tint = LightBrown
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Column() {
                                    Text(
                                        text = selectedPaymentMode,
                                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                                    )
                                    Text(
                                        text = "$ $totalAmount",
                                        style = MaterialTheme.typography.bodyLarge
                                    )

                                }
                            }

                            Box {
                                Icon(
                                    painter = painterResource(id = R.drawable.regular_outline_arrow_down),
                                    contentDescription = "Change Payment Mode",
                                    modifier = Modifier
                                        .size(25.dp)
                                        .clickable { expanded = true },
                                )
                            }
                        }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            paymentMode.forEach { mode ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = mode,
                                            style = MaterialTheme.typography.bodyLarge
                                        )
                                    },
                                    onClick = {
                                        selectedPaymentMode = mode
                                        expanded = false
                                    },
                                    modifier = Modifier.background(
                                        color = if (mode == selectedPaymentMode) LightBrown.copy(alpha = 0.2f)
                                        else Color.Transparent
                                    ),
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            shape = RoundedCornerShape(10.dp),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = LightBrown,
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                text = "Place Order",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
