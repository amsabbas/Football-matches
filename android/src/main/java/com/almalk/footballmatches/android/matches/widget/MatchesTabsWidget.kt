package com.almalk.footballmatches.android.matches.widget


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.almalk.footballmatches.android.R
import com.almalk.footballmatches.android.base.widget.AppTheme
import com.almalk.footballmatches.android.matches.viewmodel.MatchesViewModel

@Composable
fun MatchesTabsWidget(matchesViewModel: MatchesViewModel = hiltViewModel()) {

    ScrollableTabRow(
        divider = { },
        edgePadding = 0.dp,
        indicator = {
            TabRowDefaults.Indicator(
                color = Color.Transparent,
                height = 0.dp
            )
        },
        selectedTabIndex = matchesViewModel.weekdaySelectedTabIndex.value,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        for (i in 0 until matchesViewModel.matchesDays) {
            Box(
                Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        matchesViewModel.weekdaySelectedTabIndex.value = i
                        matchesViewModel.getMatches()
                    }) {

                Text(
                    text = stringResource(id = R.string.week_day_title) + " ${i + 1}",
                    color = if (matchesViewModel.weekdaySelectedTabIndex.value == i)
                        colorResource(id = AppTheme.colors.white)
                    else
                        colorResource(id = AppTheme.colors.white60),
                    style = AppTheme.typography.subBody,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(4.dp)
                )
            }
        }
    }
}