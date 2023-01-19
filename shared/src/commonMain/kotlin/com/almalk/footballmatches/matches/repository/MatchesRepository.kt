package com.almalk.footballmatches.matches.repository

import com.almalk.footballmatches.matches.model.Matches
import kotlinx.coroutines.flow.Flow

class MatchesRepository(private val remoteDataSource: MatchesRemoteDataSource) {
    suspend fun getMatches(): Flow<Matches> {
        return remoteDataSource.getMatches()
    }
}