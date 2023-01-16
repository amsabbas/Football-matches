package com.almalk.footballmatches.android.home.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.almalk.footballmatches.android.base.extension.removeSystemWindowInsetPadding
import com.almalk.footballmatches.android.home.screen.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.decorView.rootView.removeSystemWindowInsetPadding()
        setContent {
            HomeScreen()
        }
    }

}


