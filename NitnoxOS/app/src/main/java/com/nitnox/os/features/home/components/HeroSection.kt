package com.nitnox.os.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HeroSection() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(420.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF16213E),
                        Color(0xFF101820),
                        Color(0xFF080808)
                    )
                ),
                shape = RoundedCornerShape(34.dp)
            )
    ) {

        // Dark overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color(0xCC000000),
                            Color(0x88000000),
                            Color.Transparent
                        )
                    ),
                    RoundedCornerShape(34.dp)
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(48.dp)
                .width(520.dp)
        ) {

            Text(
                text = "FEATURED",
                color = Color(0xFF9AA4B2)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "DUNE",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Adventure • Sci-Fi • 2024 • IMAX",
                color = Color(0xFFCFCFCF)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Paul Atreides unites with the Fremen while seeking revenge against those who destroyed his family.",
                color = Color.White.copy(alpha = .85f),
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row {

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Text("▶ Watch Now")
                }

                Spacer(modifier = Modifier.width(16.dp))

                OutlinedButton(
                    onClick = { }
                ) {
                    Text("More Info")
                }
            }
        }
    }
}