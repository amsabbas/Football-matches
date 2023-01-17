package com.almalk.footballmatches.android.matches.widget

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.almalk.footballmatches.android.base.extension.formatDateByHourMin
import com.almalk.footballmatches.android.base.widget.AppTheme
import com.almalk.footballmatches.matches.model.Score

@Composable
fun MatchesScoreWidget(score: Score?, date: String?) {
    if (score?.winner != null) {
        Text(
            text = score.fullTime?.home.toString() + ":" + score.fullTime?.away.toString(),
            color = colorResource(id = AppTheme.colors.green),
            style = AppTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Bold
            ),
        )
    } else {
        Text(
            text = date.formatDateByHourMin(),
            color = colorResource(id = AppTheme.colors.green),
            style = AppTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Bold
            ),
        )
    }
}