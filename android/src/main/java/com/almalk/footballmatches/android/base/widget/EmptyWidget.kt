package com.almalk.footballmatches.android.base.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.almalk.footballmatches.android.R
@Composable
fun EmptyWidget(
    modifier: Modifier = Modifier,
    message: String,
) {
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_warning),
            contentDescription = "",
            contentScale = ContentScale.None,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(colorResource(id = AppTheme.colors.orange))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            message,
            color = colorResource(id = AppTheme.colors.gray),
            style = AppTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}