package com.almalk.footballmatches.android.matches.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.almalk.footballmatches.android.R
import com.almalk.footballmatches.android.base.widget.AppTheme
import com.almalk.footballmatches.matches.model.Competition

@Composable
fun MatchesHeaderWidget(competition: Competition?, season: String?) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.green))
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        verticalArrangement = Arrangement.Center,

        ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
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
                    .size(90.dp),
                colorFilter = ColorFilter.tint(
                    colorResource(
                        id = AppTheme.colors.white
                    )
                ),
                contentScale = ContentScale.FillBounds,
            )


            Text(
                text = stringResource(id = R.string.season_title) + " $season",
                color = colorResource(id = AppTheme.colors.white),
                style = AppTheme.typography.subBody.copy(
                    fontWeight = FontWeight.Bold
                ),
            )
        }
    }

}