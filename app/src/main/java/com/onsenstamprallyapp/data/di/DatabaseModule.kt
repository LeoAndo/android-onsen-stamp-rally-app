package com.onsenstamprallyapp.data.di

import android.content.Context
import com.onsenstamprallyapp.data.room.OnsenDatabase
import com.onsenstamprallyapp.data.room.dao.OnsenDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    internal fun provideOnsenDatabase(@ApplicationContext context: Context): OnsenDatabase {
        return OnsenDatabase.getInstance(context)
    }

    @Provides
    internal fun provideOnsenDao(database: OnsenDatabase): OnsenDao {
        return database.onsenDao()
    }
}