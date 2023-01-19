package com.almalk.footballmatches.teams.repository

import com.almalk.footballmatches.matches.model.Team
import kotlinx.coroutines.flow.Flow

class TeamsRepository(private val teamsLocalDataSource: TeamsLocalDataSource) {
    suspend fun getFavoriteTeams(): Flow<List<Team>> {
        return teamsLocalDataSource.getFavoriteTeams()
    }

    suspend fun insertFavoriteTeam(team: Team): Flow<Unit> {
        return teamsLocalDataSource.insertFavoriteTeam(team)
    }
}