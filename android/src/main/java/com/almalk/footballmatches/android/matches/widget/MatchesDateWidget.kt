package com.almalk.footballmatches.android.matches.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.almalk.footballmatches.android.R
import com.almalk.footballmatches.android.base.extension.formatDate
import com.almalk.footballmatches.android.base.widget.AppTheme
import com.almalk.footballmatches.matches.model.Match

@Composable
fun MatchesDateWidget(match: Match?, previousMatch: Match?) {

    val date = match?.utcDate?.formatDate()
    val previousDate = previousMatch?.utcDate?.formatDate()

    if (date != null && date != previousDate) {
        Text(
            text = date,
            color = colorResource(id = AppTheme.colors.gray),
            style = AppTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.gray_60)),
            textAlign = TextAlign.Center
        )
    }


}