package com.ma.basloq.android.di

import android.content.Context
import com.ma.basloq.data.repo.source.BasloqDatabaseFactory
import com.ma.basloq.data.repo.source.DatabaseDriverFactory
import com.ma.basloq.database.BasloqDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideBasloqDatabase(
        @ApplicationContext context: Context
    ): BasloqDatabase {
        return BasloqDatabaseFactory(
            driver = DatabaseDriverFactory(context = context)
        )
            .createDatabase()
    }
}