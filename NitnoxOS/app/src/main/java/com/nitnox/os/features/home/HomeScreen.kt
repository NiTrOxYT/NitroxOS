package com.nitnox.os.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nitnox.os.features.home.components.Background
import com.nitnox.os.features.home.components.ContinueWatching
import com.nitnox.os.features.home.components.FavoriteApps
import com.nitnox.os.features.home.components.HeroSection
import com.nitnox.os.features.home.components.LeftNavigation
import com.nitnox.os.features.home.components.TopNavigation

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Background()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            TopNavigation()

            Spacer(modifier = Modifier.height(24.dp))

            Row(modifier = Modifier.weight(1f)) {
                LeftNavigation()

                Spacer(modifier = Modifier.width(24.dp))

                Column(modifier = Modifier.weight(1f)) {
                    HeroSection()

                    Spacer(modifier = Modifier.height(32.dp))

                    ContinueWatching()

                    Spacer(modifier = Modifier.height(24.dp))

                    FavoriteApps()
                }
            }
        }
    }
}