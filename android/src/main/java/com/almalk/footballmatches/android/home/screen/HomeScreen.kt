package com.almalk.footballmatches.android.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.almalk.footballmatches.android.base.model.Constants
import com.almalk.footballmatches.android.base.widget.AppThemeWidget
import com.almalk.footballmatches.android.home.widget.BottomBarNavigation
import com.almalk.footballmatches.android.home.widget.BottomItemWidget
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding

@Composable
fun HomeScreen() {

    val navController = rememberNavController()
    AppThemeWidget {
        ProvideWindowInsets {
            Scaffold(
                bottomBar = {
                    BottomAppBar(
                        modifier = Modifier
                            .navigationBarsPadding()
                            .height(Constants.BOTTOM_NAVIGATION_HEIGHT.dp)
                            .graphicsLayer {
                                clip = true
                                shape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp)
                                shadowElevation = 20f
                            },
                        cutoutShape = CircleShape,
                        elevation = 0.dp,
                    ) {
                        BottomItemWidget(navController)
                    }
                },
                content = { padding ->
                    Box(Modifier.padding(padding)) {
                        BottomBarNavigation(navController)
                    }
                }
            )
        }
    }
}