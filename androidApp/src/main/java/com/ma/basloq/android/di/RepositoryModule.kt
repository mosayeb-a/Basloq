package com.ma.basloq.android.di

import android.app.Application
import com.ma.basloq.service.UserService
import com.ma.basloq.data.preferences.PlatformContext
import com.ma.basloq.data.preferences.PlatformPreferences
import com.ma.basloq.data.repo.QuoteRepository
import com.ma.basloq.data.repo.QuoteRepositoryImpl
import com.ma.basloq.data.repo.UserRepository
import com.ma.basloq.data.repo.UserRepositoryImpl
import com.ma.basloq.data.repo.source.QuoteLocalDataSource
import com.ma.basloq.data.repo.source.QuoteRemoteDataSource
import com.ma.basloq.data.repo.source.UserLocalDataSource
import com.ma.basloq.data.repo.source.UserRemoteDataSource
import com.ma.basloq.service.QuoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    fun providePlatformContext(
        @ApplicationContext context: Application,
    ): PlatformPreferences {
        return PlatformPreferences(context)
    }

    @Provides
    @ViewModelScoped
    fun provideUserLocalDataSource(
        platformContext: PlatformContext
    ): UserLocalDataSource {
        return UserLocalDataSource(
            PlatformPreferences(
                context = platformContext
            )
        )
    }

    @Provides
    @ViewModelScoped
    fun provideUserRemoteDataSource(
        userService: UserService
    ): UserRemoteDataSource {
        return UserRemoteDataSource(
            userService = userService
        )
    }

    @Provides
    @ViewModelScoped
    fun provideUserRepository(
        userLocalDataSource: UserLocalDataSource,
        userRemoteDataSource: UserRemoteDataSource
    ): UserRepository {
        return UserRepositoryImpl(
            userLocalDataSource = userLocalDataSource,
            userRemoteDataSource = userRemoteDataSource
        )
    }

    @Provides
    @ViewModelScoped
    fun provideQuoteLocalDataSource(): QuoteLocalDataSource {
        return QuoteLocalDataSource()
    }

    @Provides
    @ViewModelScoped
    fun provideQuoteRemoteDataSource(
        quoteService: QuoteService
    ): QuoteRemoteDataSource {
        return QuoteRemoteDataSource(quoteService)
    }

    @Provides
    @ViewModelScoped
    fun provideQuoteRepository(
        quoteLocalDataSource: QuoteLocalDataSource,
        quoteRemoteDataSource: QuoteRemoteDataSource
    ): QuoteRepository {
        return QuoteRepositoryImpl(
            quoteLocalDataSource = quoteLocalDataSource,
            quoteRemoteDataSource = quoteRemoteDataSource
        )
    }
}