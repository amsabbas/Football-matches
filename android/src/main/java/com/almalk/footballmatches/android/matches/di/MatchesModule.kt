package com.almalk.footballmatches.android.matches.di


import com.almalk.footballmatches.android.matches.viewmodel.MatchesViewModel
import com.almalk.footballmatches.base.network.KtorHttpClient
import com.almalk.footballmatches.matches.model.MatchesMemoryCache
import com.almalk.footballmatches.matches.repository.MatchesRemoteDataSource
import com.almalk.footballmatches.matches.repository.MatchesRepository
import com.almalk.footballmatches.matches.usecase.MatchesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object MatchesModule {

    @Provides
    fun provideMatchesRepository(remoteDataSource: MatchesRemoteDataSource): MatchesRepository {
        return MatchesRepository(remoteDataSource)
    }

    @Provides
    fun provideMatchesMemoryCache(): MatchesMemoryCache {
        return MatchesMemoryCache()
    }

    @Provides
    fun provideMatchesUseCase(repository: MatchesRepository): MatchesUseCase {
        return MatchesUseCase(repository)
    }

    @Provides
    fun provideMatchesRemoteDataSource(
        httpClient: KtorHttpClient,
        matchesMemoryCache: MatchesMemoryCache
    ): MatchesRemoteDataSource {
        return MatchesRemoteDataSource(httpClient, matchesMemoryCache)
    }

    @Provides
    fun provideMatchesViewModel(matchesUseCase: MatchesUseCase): MatchesViewModel =
        MatchesViewModel(matchesUseCase)


}
