package com.ma.basloq.android.di

import com.ma.basloq.service.UserService
import com.ma.basloq.KtorClientFactory
import com.ma.basloq.service.QuoteService
import com.ma.basloq.service.QuoteServiceImpl
import com.ma.basloq.service.UserServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideUserService(
        httpClient: HttpClient
    ) : UserService {
        return UserServiceImpl(
            httpClient = httpClient
        )
    }

    @Singleton
    @Provides
    fun provideQuoteService(
        httpClient: HttpClient
    ) : QuoteService {
        return QuoteServiceImpl(
            httpClient = httpClient
        )
    }
}