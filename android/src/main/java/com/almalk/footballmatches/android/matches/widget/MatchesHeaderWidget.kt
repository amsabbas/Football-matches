package com.almalk.footballmatches.android.matches.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.almalk.footballmatches.android.R
import com.almalk.footballmatches.android.base.widget.AppTheme
import com.almalk.footballmatches.matches.model.Competition

@Composable
fun MatchesHeaderWidget(competition: Competition?) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.green)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(competition?.emblem)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.app_name),
            placeholder = painterResource(R.drawable.ic_loading_image),
            error = (painterResource(R.drawable.ic_loading_image)),
            modifier = Modifier
                .size(160.dp),
            colorFilter = ColorFilter.tint(
                colorResource(
                    id = AppTheme.colors.white
                )
            ),
            contentScale = ContentScale.FillBounds,
        )
    }

}