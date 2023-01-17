package com.almalk.footballmatches.android.matches.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceEvenly
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
            resource.data.matches.forEachIndexed { index, match ->

                item {

                    Column(Modifier.fillMaxWidth()) {

                        MatchesDateWidget(
                            match = match,
                            previousMatch = if (index > 0) resource.data.matches[index - 1] else null
                        )

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

                            MatchesScoreWidget(score = match.score, match.utcDate)

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
}

