package com.almalk.footballmatches.android.matches.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceEvenly
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.almalk.footballmatches.android.base.widget.AppTheme
import com.almalk.footballmatches.android.matches.viewmodel.MatchesViewModel

@Composable
fun MatchesWeekDayWidget(matchesViewModel: MatchesViewModel = hiltViewModel()) {

    val resource = matchesViewModel.matchesState.collectAsState().value

    resource.data?.let {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            resource.data.matches.forEach { match ->
                item {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = SpaceEvenly,
                        verticalAlignment = Top
                    ) {

                        match.homeTeam?.let {
                            MatchesTeamWidget(teamImageURL = it.crest, teamName = it.name)
                        }

                        Spacer(modifier = Modifier.width(12.dp))
                        match.score?.let {
                            if (it.winner != null) {
                                Text(
                                    text = it.fullTime?.home.toString() + ":" + it.fullTime?.away.toString(),
                                    color = colorResource(id = AppTheme.colors.green),
                                    style = AppTheme.typography.subtitle2.copy(
                                        fontWeight = FontWeight.Bold
                                    ),
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        match.awayTeam?.let {
                            MatchesTeamWidget(teamImageURL = it.crest, teamName = it.name)
                        }
                    }
                }
            }
        }
    }
}
