package com.almalk.footballmatches.android.base.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.almalk.footballmatches.android.R

class AppColors(
    white: Int,
    green: Int,
    gray: Int,
    white60: Int,
    red: Int,
    orange: Int,
) {
    var white by mutableStateOf(white)
        private set
    var green by mutableStateOf(green)
        private set
    var gray by mutableStateOf(gray)
        private set
    var gray80 by mutableStateOf(white60)
        private set
    var red by mutableStateOf(red)
        private set
    var orange by mutableStateOf(orange)
        private set
}

fun lightColors(
): AppColors = AppColors(
    white = R.color.white,
    green = R.color.green,
    gray = R.color.gray,
    white60 = R.color.white_60,
    red = R.color.red,
    orange = R.color.orange,
)

fun darkColors(
): AppColors = AppColors(
    white = R.color.white,
    green = R.color.green,
    gray = R.color.gray,
    white60 = R.color.white_60,
    red = R.color.red,
    orange = R.color.orange,
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }
