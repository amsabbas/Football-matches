package com.almalk.footballmatches.android.base.extension

import android.view.View
import androidx.core.view.ViewCompat

@Suppress("DEPRECATION")
fun View.removeSystemWindowInsetPadding(
) {
    ViewCompat.setOnApplyWindowInsetsListener(this) { _, insets ->
        ViewCompat.onApplyWindowInsets(
            this,
            insets.replaceSystemWindowInsets(
                insets.systemWindowInsetLeft,
                0,
                insets.systemWindowInsetRight,
                insets.systemWindowInsetBottom
            )
        )
    }
}