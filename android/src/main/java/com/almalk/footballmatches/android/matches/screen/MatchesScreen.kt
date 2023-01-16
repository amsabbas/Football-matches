package com.almalk.footballmatches.android.matches.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.almalk.footballmatches.android.R
import com.almalk.footballmatches.android.base.model.ResourceState
import com.almalk.footballmatches.android.base.widget.ErrorWidget
import com.almalk.footballmatches.android.base.widget.LoadingWidget
import com.almalk.footballmatches.android.matches.viewmodel.MatchesViewModel
import com.almalk.footballmatches.android.matches.widget.MatchesHeaderWidget
import com.almalk.footballmatches.android.matches.widget.MatchesTabsWidget
import com.almalk.footballmatches.android.matches.widget.MatchesWeekDayWidget

@Composable
fun MatchesScreen(matchesViewModel: MatchesViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        matchesViewModel.getMatches()
    }

    val resource = matchesViewModel.matchesState.collectAsState().value


    when (resource.state) {
        ResourceState.Loading -> {
            LoadingWidget(Modifier.fillMaxSize())
        }
        ResourceState.Error -> {
            ErrorWidget(
                buttonPositiveTitle = stringResource(id = R.string.retry),
                message = resource.exception?.message
                    ?: stringResource(id = R.string.unknown_error),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                onPositiveClick = { matchesViewModel.getMatches() },
            )
        }
        ResourceState.Success -> {
            Column {
                MatchesHeaderWidget(resource.data?.competition)
                MatchesTabsWidget()
                MatchesWeekDayWidget()
            }
        }
        else -> {

        }
    }

}