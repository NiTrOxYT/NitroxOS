package com.nitnox.os.core.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TvFocusable(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    var focused by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        if (focused) 1.08f else 1f,
        label = ""
    )

    val border by animateColorAsState(
        if (focused)
            Color.White
        else
            Color.Transparent,
        label = ""
    )

    Box(
        modifier = modifier
            .scale(scale)
            .border(
                2.dp,
                border,
                RoundedCornerShape(26.dp)
            )
            .onFocusChanged {
                focused = it.isFocused
            }
            .focusable(
                interactionSource = remember {
                    MutableInteractionSource()
                }
            )
    ) {
        content()
    }
}