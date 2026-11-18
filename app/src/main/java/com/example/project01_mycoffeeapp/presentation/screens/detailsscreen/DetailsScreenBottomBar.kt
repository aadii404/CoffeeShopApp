package com.example.project01_mycoffeeapp.presentation.screens.detailsscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project01_mycoffeeapp.presentation.theme.IvoryWhite
import com.example.project01_mycoffeeapp.presentation.theme.LightBrown
import com.example.project01_mycoffeeapp.presentation.ui_components.AppMessageDialog

@Preview(showBackground = true)
@Composable
fun DetailsScreenBottomBar() {

    var showCartDialog by remember { mutableStateOf(false) }
    BottomAppBar(
        containerColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Column() {
                Text(
                    text = "Price",
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$4.35",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(
                onClick = {showCartDialog = true },
                modifier = Modifier
                    .weight(1f)
                    .height(55.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = IvoryWhite
                )
            ) {
                Text(
                    text = "Add to Cart",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            AppMessageDialog(
                show = showCartDialog,
                title = "Success",
                message = "Item added to cart",
                onDismiss = { showCartDialog = false}
            )
        }
    }
}