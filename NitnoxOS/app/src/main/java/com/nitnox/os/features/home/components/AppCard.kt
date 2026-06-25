package com.nitnox.os.features.home.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AppCard(
    title: String,
    modifier: Modifier = Modifier
) {

    var focused by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (focused) 1.08f else 1f,
        label = "scale"
    )

    val borderColor by animateColorAsState(
        targetValue =
            if (focused)
                Color.White.copy(alpha = .75f)
            else
                Color.White.copy(alpha = .10f),
        label = "border"
    )

    val backgroundColor by animateColorAsState(
        targetValue =
            if (focused)
                Color.White.copy(alpha = .12f)
            else
                Color.White.copy(alpha = .05f),
        label = "background"
    )

    Box(
        modifier = modifier
            .size(
                width = 170.dp,
                height = 190.dp
            )
            .scale(scale)
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        backgroundColor,
                        Color.White.copy(alpha = .02f)
                    )
                ),
                shape = RoundedCornerShape(28.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(28.dp)
            )
            .onFocusChanged {
                focused = it.isFocused
            }
            .focusable(
                interactionSource = remember {
                    MutableInteractionSource()
                }
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .background(
                        Brush.radialGradient(
                            listOf(
                                Color.White.copy(.25f),
                                Color.White.copy(.05f)
                            )
                        ),
                        RoundedCornerShape(22.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = title.first().toString(),
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
        }

        if (focused) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                Color.White.copy(alpha = .08f),
                                Color.Transparent
                            )
                        ),
                        RoundedCornerShape(28.dp)
                    )
            )
        }
    }
}