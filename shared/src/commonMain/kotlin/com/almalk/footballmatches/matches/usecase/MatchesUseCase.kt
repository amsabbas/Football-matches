package com.almalk.footballmatches.matches.usecase

import com.almalk.footballmatches.matches.model.Matches
import com.almalk.footballmatches.matches.network.MatchesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MatchesUseCase(
    private val matchesRepository: MatchesRepository
) {
    suspend fun getMatches(matchDay: Int): Flow<Matches> {
        return matchesRepository.getMatches().map {
            it.copy(matches = it.matches.filter { match ->
                match.matchday == matchDay
            })
        }
    }
}