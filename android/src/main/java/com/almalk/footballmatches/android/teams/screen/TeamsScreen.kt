package com.almalk.footballmatches.android.teams.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.almalk.footballmatches.android.R
import com.almalk.footballmatches.android.base.widget.AppTheme

@Composable
fun TeamsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.teams_tab_title),
            style = AppTheme.typography.body,
            color = colorResource(id = AppTheme.colors.gray)
        )
    }
}