package com.nitnox.os.features.home.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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

private data class Movie(
    val title: String,
    val progress: Float,
    val rating: String
)

@Composable
fun ContinueWatching() {

    val movies = listOf(
        Movie("Dune", 0.72f, "8.9"),
        Movie("Interstellar", 0.45f, "9.2"),
        Movie("Batman", 0.30f, "8.6"),
        Movie("Oppenheimer", 0.18f, "8.8"),
        Movie("Blade Runner", 0.82f, "8.4")
    )

    Column {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                "Continue Watching",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                "See All",
                color = Color(0xFF64B5F6)
            )
        }

        Spacer(Modifier.height(22.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            items(movies) {

                ContinueMovieCard(it)
            }
        }
    }
}

@Composable
private fun ContinueMovieCard(
    movie: Movie
) {

    var focused by remember {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        if (focused) 1.05f else 1f,
        label = ""
    )

    val border by animateColorAsState(
        if (focused)
            Color.White
        else
            Color.White.copy(.10f),
        label = ""
    )

    Box(
        modifier = Modifier
            .scale(scale)
            .width(320.dp)
            .height(180.dp)
            .border(
                1.dp,
                border,
                RoundedCornerShape(26.dp)
            )
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF263238),
                        Color(0xFF101214)
                    )
                ),
                RoundedCornerShape(26.dp)
            )
            .focusable(
                interactionSource = remember {
                    MutableInteractionSource()
                }
            )
            .onFocusChanged {
                focused = it.isFocused
            }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color.Black.copy(.75f),
                            Color.Transparent
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(22.dp)
        ) {

            Text(
                movie.title,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(10.dp))

            Text(
                "IMDb ${movie.rating}",
                color = Color(0xFFB0BEC5)
            )

            Spacer(Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(6.dp)
                    .background(
                        Color.White.copy(.10f),
                        RoundedCornerShape(50)
                    )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(movie.progress)
                        .background(
                            Color.White,
                            RoundedCornerShape(50)
                        )
                )
            }
        }
    }
}