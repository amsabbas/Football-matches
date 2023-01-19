package com.almalk.footballmatches.teams.repository

import com.almalk.footballmatches.base.database.Database
import com.almalk.footballmatches.base.database.DatabaseDriverFactory
import com.almalk.footballmatches.matches.model.Team
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TeamsLocalDataSource(
    databaseDriverFactory: DatabaseDriverFactory
) {
    private val database = Database(databaseDriverFactory)

    suspend fun getFavoriteTeams(): Flow<List<Team>> {
        return flow {
            val teams = database.getAllTeams()
            emit(teams)
        }
    }

    suspend fun insertFavoriteTeam(team: Team): Flow<Unit> {
        return flow {
            database.insertTeam(team)
        }
    }
}