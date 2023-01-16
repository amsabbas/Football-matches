package com.almalk.footballmatches.android.home.viewmodel


import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.almalk.footballmatches.android.base.widget.AppTheme
import com.almalk.footballmatches.android.home.model.BottomItemNavigationModel


import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

    @Composable
    fun getTabColor(currentRoute: String?, selectedRoute: String?): Int {
        return if (currentRoute == selectedRoute)
            AppTheme.colors.white
        else
            AppTheme.colors.gray80
    }

    fun isTabSelected(currentRoute: String?, selectedRoute: String?): Boolean {
        return currentRoute == selectedRoute

    }

    fun getHomeList(): List<BottomItemNavigationModel> {
        return listOf(
            BottomItemNavigationModel.Matches,
            BottomItemNavigationModel.Teams,
        )
    }

}

