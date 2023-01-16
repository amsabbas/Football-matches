package com.almalk.footballmatches.android.matches.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun MatchesTeamWidget(teamImageURL: String?, teamName: String?) {
    Row(verticalAlignment = Alignment.Top) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(teamImageURL)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.app_name),
            placeholder = painterResource(R.drawable.ic_loading_image),
            error = (painterResource(R.drawable.ic_loading_image)),
            modifier = Modifier
                .size(20.dp),
            contentScale = ContentScale.FillBounds,
        )


        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = teamName ?: "",
            color = colorResource(id = AppTheme.colors.gray),
            style = AppTheme.typography.subtitle2,
            modifier = Modifier.width(100.dp)
        )
    }
}