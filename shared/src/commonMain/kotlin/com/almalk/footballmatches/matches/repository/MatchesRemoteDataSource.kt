package com.almalk.footballmatches.matches.repository

import com.almalk.footballmatches.base.network.KtorHttpClient
import com.almalk.footballmatches.base.utils.Constants
import com.almalk.footballmatches.matches.model.Matches
import com.almalk.footballmatches.matches.model.MatchesMemoryCache
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MatchesRemoteDataSource(
    private val ktorHttpClient: KtorHttpClient,
    private val matchesMemoryCache: MatchesMemoryCache
) {
    suspend fun getMatches(): Flow<Matches> {
        return flow {
            if (matchesMemoryCache.matches == null) {
                val matches =
                    ktorHttpClient.httpClient
                        .get(Constants.BASE_URL + "v4/competitions/PL/matches")
                        .body<Matches>()
                matchesMemoryCache.matches = matches
            }
            emit(matchesMemoryCache.matches!!)
        }
    }
}