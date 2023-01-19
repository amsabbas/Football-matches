package com.almalk.footballmatches.android.teams.di


import com.almalk.footballmatches.android.teams.viewmodel.TeamsViewModel
import com.almalk.footballmatches.base.database.DatabaseDriverFactory
import com.almalk.footballmatches.teams.repository.TeamsLocalDataSource
import com.almalk.footballmatches.teams.repository.TeamsRepository
import com.almalk.footballmatches.teams.usecase.TeamsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object TeamsModule {

    @Provides
    fun provideTeamsLocalDataSource(
        databaseDriverFactory: DatabaseDriverFactory
    ): TeamsLocalDataSource {
        return TeamsLocalDataSource(databaseDriverFactory)
    }

    @Provides
    fun provideTeamsRepository(localDataSource: TeamsLocalDataSource): TeamsRepository {
        return TeamsRepository(localDataSource)
    }

    @Provides
    fun provideMatchesUseCase(repository: TeamsRepository): TeamsUseCase {
        return TeamsUseCase(repository)
    }

    @Provides
    fun provideMatchesViewModel(teamsUseCase: TeamsUseCase): TeamsViewModel =
        TeamsViewModel(teamsUseCase)


}
