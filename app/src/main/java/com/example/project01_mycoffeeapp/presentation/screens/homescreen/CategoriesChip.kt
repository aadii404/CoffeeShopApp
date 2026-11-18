package com.example.project01_mycoffeeapp.presentation.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project01_mycoffeeapp.presentation.theme.LightBrown
import com.example.project01_mycoffeeapp.presentation.theme.LightGray

@Composable
fun CategoriesChip(
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Box(
        modifier = modifier
            .width(90.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(
                color = if (isSelected) LightBrown
                else LightGray.copy(alpha = 0.6f)
            )
            .clickable { onSelected() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
            )
    }
}