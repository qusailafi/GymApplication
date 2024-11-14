package com.example.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY )
annotation class  MainDispatcher
@Module
@InstallIn(SingletonComponent::class )
object DispatcherModule {
    @MainDispatcher
    @Provides
    fun proviedMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}