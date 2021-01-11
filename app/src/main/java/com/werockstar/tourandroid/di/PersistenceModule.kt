package com.werockstar.tourandroid.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

	@Provides
	fun provideSharePreference(application: Application) =
		application.getSharedPreferences("tour", Context.MODE_PRIVATE)
}
