package com.almalk.footballmatches.android.base.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
fun ErrorWidget(
    modifier: Modifier = Modifier,
    message: String,
    buttonPositiveTitle: String,
    onPositiveClick: () -> Unit,
) {

    val color = colorResource(id = AppTheme.colors.red)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Image(

            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = "",
            contentScale = ContentScale.None,
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(color)
        )

        Spacer(modifier = Modifier.height(24.dp))


        Text(
            message,
            color = colorResource(id = AppTheme.colors.gray),
            style = AppTheme.typography.h6,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .width(265.dp)
                .padding(horizontal = 24.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() })
                { onPositiveClick.invoke() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {

            Icon(
                Icons.Outlined.Refresh,
                "",
                tint = colorResource(id = AppTheme.colors.gray),
                modifier = Modifier
                    .size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = buttonPositiveTitle,
                color = colorResource(id = AppTheme.colors.gray),
                style = AppTheme.typography.h6,
            )
        }

    }
}