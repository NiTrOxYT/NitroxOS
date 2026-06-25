package com.nitnox.os.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Background() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF040507))
    ) {

        // Main ambient gradient
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF3A5FFF).copy(alpha = 0.55f),
                            Color(0xFF17213D).copy(alpha = 0.55f),
                            Color(0xFF090B10),
                            Color(0xFF040507)
                        ),
                        center = Offset(1150f, 260f),
                        radius = 1700f
                    )
                )
        )

        // Soft cyan accent
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF00D9FF).copy(alpha = 0.12f),
                            Color.Transparent
                        ),
                        center = Offset(180f, 220f),
                        radius = 700f
                    )
                )
        )

        // Bottom cinematic fade
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.15f),
                            Color.Black.copy(alpha = 0.55f),
                            Color.Black.copy(alpha = 0.92f)
                        )
                    )
                )
        )

        // Left vignette
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.55f),
                            Color.Black.copy(alpha = 0.15f),
                            Color.Transparent
                        )
                    )
                )
        )

        // Top highlight
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.025f),
                            Color.Transparent
                        )
                    )
                )
        )
    }
}