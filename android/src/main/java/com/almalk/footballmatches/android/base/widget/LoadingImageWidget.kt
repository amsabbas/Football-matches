package com.almalk.footballmatches.android.base.widget

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.almalk.footballmatches.android.R

@Composable
fun LoadingImageWidget() {
    Image(
        painter = painterResource(id = R.drawable.ic_loading_image),
        contentDescription = "",
        contentScale = ContentScale.None,
    )
}
