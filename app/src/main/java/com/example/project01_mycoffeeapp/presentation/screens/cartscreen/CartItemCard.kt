package com.example.project01_mycoffeeapp.presentation.screens.cartscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project01_mycoffeeapp.R
import com.example.project01_mycoffeeapp.domain.model.Product
import com.example.project01_mycoffeeapp.presentation.theme.LightBrown
import org.intellij.lang.annotations.JdkConstants


@Composable
fun CartItemCard(product: Product) {

    var quantity by remember { mutableStateOf(1) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = "Coffee Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.DarkGray)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                IconButton(
                    onClick = { quantity-- },
                    enabled = quantity > 1,
                    modifier = Modifier
                        .background(
                            color = LightBrown.copy(alpha = 0.2f),
                            shape = CircleShape
                        )
                        .size(30.dp)
                ) {
                    Icon(
                        imageVector = androidx.compose.material.icons.Icons.Default.Remove,
                        contentDescription = "Decrease Quantity",
                        tint = LightBrown
                    )
                }

                Text(
                    text = quantity.toString(),
                    modifier = Modifier.padding(horizontal = 12.dp),
                    fontSize = 18.sp
                )


                IconButton(
                    onClick = { quantity++ },
                    modifier = Modifier
                        .background(
                            color = LightBrown.copy(alpha = 0.2f),
                            shape = CircleShape
                        )
                        .size(30.dp)
                ) {
                    Icon(
                        imageVector = androidx.compose.material.icons.Icons.Default.Add,
                        contentDescription = "Increase Quantity",
                        tint = LightBrown
                    )
                }
            }
        }
    }
}