package com.almalk.footballmatches.android.home.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.almalk.footballmatches.android.base.widget.AppTheme
import com.almalk.footballmatches.android.home.viewmodel.MainViewModel


@Composable
fun BottomItemWidget(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel()
) {

    val items = mainViewModel.getHomeList()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier,
        elevation = 0.dp
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Box(modifier = Modifier.padding(4.dp)) {
                        Image(
                            painter = painterResource(id = it.icon),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(
                                colorResource(
                                    id = mainViewModel.getTabColor(currentRoute?.route, it.route)
                                )
                            ),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                label = {
                    Text(
                        modifier = Modifier,
                        text = stringResource(id = it.title),
                        style = AppTheme.typography.subBody,
                    )
                },
                selected = mainViewModel.isTabSelected(currentRoute?.route, it.route),
                selectedContentColor = colorResource(id = AppTheme.colors.white),
                unselectedContentColor = colorResource(id = AppTheme.colors.gray80),
                onClick = {
                    navController.navigate(it.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

