package com.almalk.footballmatches.android.base.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.almalk.footballmatches.android.R

class AppColors(
    white: Int,
    white60: Int,
    green: Int,
    gray: Int,
    gray60: Int,
    red: Int,
    orange: Int,
) {
    var white by mutableStateOf(white)
        private set
    var white60 by mutableStateOf(white60)
        private set
    var green by mutableStateOf(green)
        private set
    var gray by mutableStateOf(gray)
        private set
    var gray60 by mutableStateOf(gray60)
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
    gray60 = R.color.gray_60,
    white60 = R.color.white_60,
    red = R.color.red,
    orange = R.color.orange,
)

fun darkColors(
): AppColors = AppColors(
    white = R.color.white,
    green = R.color.green,
    gray = R.color.gray,
    gray60 = R.color.gray_60,
    white60 = R.color.white_60,
    red = R.color.red,
    orange = R.color.orange,
)

internal val LocalColors = staticCompositionLocalOf { lightColors() }
