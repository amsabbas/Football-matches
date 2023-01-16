package com.almalk.footballmatches.android.base.widget

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.almalk.footballmatches.android.base.utils.*
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

object AppTheme {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

}

@Composable
fun AppThemeWidget(
    colors: AppColors = if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate
            .MODE_NIGHT_YES
    ) darkColors() else lightColors(),
    typography: AppTypography = AppTheme.typography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography
    ) {
        StatusAppBarColor(color = Color.Transparent)
        MaterialTheme(
            content = content,
            colors = androidx.compose.material.lightColors(
                primary = colorResource(id = AppTheme.colors.green),
                primaryVariant = colorResource(id = AppTheme.colors.white),
                background = colorResource(id = AppTheme.colors.white),
                secondary = colorResource(id = AppTheme.colors.white),
            ),
        )
    }
}

@Composable
fun StatusAppBarColor(color: Color) {
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(darkIcons = true, color = color)
}