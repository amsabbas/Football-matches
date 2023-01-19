package com.almalk.footballmatches.android.teams.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.almalk.footballmatches.android.R
import com.almalk.footballmatches.android.base.model.ResourceState
import com.almalk.footballmatches.android.base.widget.AppTheme
import com.almalk.footballmatches.android.base.widget.ErrorWidget
import com.almalk.footballmatches.android.base.widget.LoadingWidget
import com.almalk.footballmatches.android.teams.viewmodel.TeamsViewModel

@Composable
fun TeamsScreen(teamsViewModel: TeamsViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        teamsViewModel.getAllFavoriteTeams()
    }

    val resource = teamsViewModel.favoriteTeamsState.collectAsState().value

    when (resource.state) {
        ResourceState.Loading -> {
            LoadingWidget(Modifier.fillMaxSize())
        }
        ResourceState.Error -> {
            ErrorWidget(
                buttonPositiveTitle = stringResource(id = R.string.retry),
                message = stringResource(R.string.unknown_error),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                onPositiveClick = { teamsViewModel.getAllFavoriteTeams() },
            )
        }
        ResourceState.Success -> {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = resource.data?.size.toString(),
                    color = colorResource(id = AppTheme.colors.green),
                    style = AppTheme.typography.subBody,
                    modifier = Modifier
                        .padding(4.dp)
                )
            }

        }
        else -> {

        }
    }
}