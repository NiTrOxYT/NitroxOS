package com.nitnox.os.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HeroBanner() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF1B1F3A),
                        Color(0xFF0D0D0D)
                    )
                ),
                shape = RoundedCornerShape(32.dp)
            )
            .padding(40.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {

            Text(
                text = "Featured",
                color = Color(0xFF9E9E9E)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "THE OBSIDIAN GATE",
                style = MaterialTheme.typography.displaySmall,
                color = Color.White
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = "A premium Android TV experience built for speed, elegance and immersion.",
                color = Color.LightGray
            )
        }
    }
}