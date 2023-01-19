package com.almalk.footballmatches.teams.usecase

import com.almalk.footballmatches.matches.model.Team
import com.almalk.footballmatches.teams.repository.TeamsRepository
import kotlinx.coroutines.flow.Flow

class TeamsUseCase(
    private val teamsRepository: TeamsRepository
) {
    suspend fun getFavoriteTeams(): Flow<List<Team>> {
        return teamsRepository.getFavoriteTeams()
    }

    suspend fun insertFavoriteTeam(team: Team): Flow<Unit> {
        return teamsRepository.insertFavoriteTeam(team)
    }
}