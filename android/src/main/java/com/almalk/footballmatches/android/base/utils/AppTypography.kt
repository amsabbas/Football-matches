package com.almalk.footballmatches.android.base.utils

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.almalk.footballmatches.android.R

private val font = FontFamily(
    Font(R.font.lato_regular, FontWeight.Normal)
)

data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),

    val h2: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp
    ),

    val h3: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),

    val h4: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),

    val h5: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    val h6: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    val body: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    val subBody: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    val subtitle1: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    val subtitle2: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    val button: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),

    val caption: TextStyle = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }
