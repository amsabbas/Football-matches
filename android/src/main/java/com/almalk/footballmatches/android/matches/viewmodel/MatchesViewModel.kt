package com.almalk.footballmatches.android.matches.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almalk.footballmatches.android.base.model.Resource
import com.almalk.footballmatches.android.base.model.ResourceState
import com.almalk.footballmatches.matches.model.Matches
import com.almalk.footballmatches.matches.usecase.MatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    private val matchesUseCase: MatchesUseCase
) : ViewModel() {

    val matchesState =
        MutableStateFlow(Resource<Matches>(ResourceState.Empty))

    val matchesDays = 38

    val weekdaySelectedTabIndex = mutableStateOf(0)

    fun getMatches() {
        viewModelScope.launch {
            matchesUseCase.getMatches(weekdaySelectedTabIndex.value + 1)
                .onStart {
                    matchesState.value = Resource(ResourceState.Loading)
                }.catch { exception ->
                    matchesState.value = Resource(ResourceState.Error, exception = exception)
                }.collect { result ->
                    matchesState.value = Resource(ResourceState.Success, data = result)
                }
        }
    }


}