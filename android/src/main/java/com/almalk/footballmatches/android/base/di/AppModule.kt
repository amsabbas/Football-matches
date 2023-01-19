package com.almalk.footballmatches.android.base.di


import android.app.Application
import android.content.Context
import com.almalk.footballmatches.base.database.DatabaseDriverFactory
import com.almalk.footballmatches.base.network.KtorHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideHttpClient(): KtorHttpClient {
        return KtorHttpClient()
    }

    @Provides
    fun provideDatabaseFactory(context: Context): DatabaseDriverFactory {
        return DatabaseDriverFactory(context)
    }


}
