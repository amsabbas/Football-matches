package com.almalk.footballmatches.android.teams.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almalk.footballmatches.android.base.model.Resource
import com.almalk.footballmatches.android.base.model.ResourceState
import com.almalk.footballmatches.matches.model.Team
import com.almalk.footballmatches.teams.usecase.TeamsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    private val teamsUseCase: TeamsUseCase
) : ViewModel() {

    val favoriteTeamsState =
        MutableStateFlow(Resource<List<Team>>(ResourceState.Empty))

    val insertFavoriteTeamState =
        MutableStateFlow(Resource<Unit>(ResourceState.Empty))

    fun getAllFavoriteTeams() {
        viewModelScope.launch {
            teamsUseCase.getFavoriteTeams()
                .onStart {
                    favoriteTeamsState.value = Resource(ResourceState.Loading)
                }.catch { exception ->
                    favoriteTeamsState.value = Resource(ResourceState.Error, exception = exception)
                }.collect { result ->
                    favoriteTeamsState.value = Resource(ResourceState.Success, data = result)
                }
        }
    }

    fun insertFavoriteTeam(team: Team) {
        viewModelScope.launch {
            teamsUseCase.insertFavoriteTeam(team)
                .onStart {
                    insertFavoriteTeamState.value = Resource(ResourceState.Loading)
                }.catch { exception ->
                    insertFavoriteTeamState.value =
                        Resource(ResourceState.Error, exception = exception)
                }.collect { result ->
                    insertFavoriteTeamState.value = Resource(ResourceState.Success, data = result)
                }
        }
    }
}