package com.nitnox.os.features.home.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LeftNavigation() {

    val items = listOf(
        "🏠",
        "🎬",
        "📺",
        "📱",
        "⚙️",
        "👤"
    )

    Column(
        modifier = Modifier
            .width(88.dp)
            .fillMaxHeight()
            .background(
                Color.White.copy(alpha = 0.05f),
                RoundedCornerShape(30.dp)
            )
            .padding(vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {

        items.forEachIndexed { index, icon ->

            NavigationItem(
                icon = icon,
                selected = index == 0
            )
        }
    }
}

@Composable
private fun NavigationItem(
    icon: String,
    selected: Boolean
) {

    var focused by remember {
        mutableStateOf(false)
    }

    val background by animateColorAsState(
        targetValue =
            if (focused || selected)
                Color.White
            else
                Color.Transparent,
        label = ""
    )

    val textColor by animateColorAsState(
        targetValue =
            if (focused || selected)
                Color.Black
            else
                Color.White,
        label = ""
    )

    Box(
        modifier = Modifier
            .size(56.dp)
            .scale(if (focused) 1.12f else 1f)
            .background(
                background,
                RoundedCornerShape(18.dp)
            )
            .focusable(
                interactionSource = remember {
                    MutableInteractionSource()
                }
            )
            .onFocusChanged {
                focused = it.isFocused
            },
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = icon,
            style = MaterialTheme.typography.titleLarge,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}