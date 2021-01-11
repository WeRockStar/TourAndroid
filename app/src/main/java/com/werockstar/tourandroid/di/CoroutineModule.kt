package com.werockstar.tourandroid.di

import com.werockstar.tourandroid.thread.AppDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class CoroutineModule {

	@Provides
	fun provideDispatcher(): AppDispatcher = AppDispatcher(Dispatchers.IO, Dispatchers.Main)
}
