package com.almalk.footballmatches.android.home.model

import com.almalk.footballmatches.android.R

sealed class BottomItemNavigationModel(val title: Int, val route: String, val icon: Int) {

    object Matches :
        BottomItemNavigationModel(R.string.matches_tab_title, "Matches", R.drawable.ic_matches)

    object Teams :
        BottomItemNavigationModel(R.string.teams_tab_title, "Teams", R.drawable.ic_team)

}