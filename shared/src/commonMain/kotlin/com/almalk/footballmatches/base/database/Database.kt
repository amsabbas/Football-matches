package com.almalk.footballmatches.base.database

import com.almalk.footballmatches.matches.model.Team

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllTeams()
        }
    }

    internal fun insertTeam(team: Team) {
        dbQuery.insertTeam(
            id = team.id?.toLong(),
            name = team.name,
            shortName = team.shortName,
            tla = team.tla,
            imageURL = team.crest
        )
    }

    internal fun getAllTeams(): List<Team> {
        return dbQuery.selectAllTeams(::mapTeamSelecting).executeAsList()
    }

    private fun mapTeamSelecting(
        id: Long?,
        name: String?,
        shortName: String?,
        tla: String?,
        crest: String?,
    ): Team {
        return Team(
            id = id?.toInt(),
            name = name,
            shortName = shortName,
            tla = tla,
            crest = crest
        )
    }
}