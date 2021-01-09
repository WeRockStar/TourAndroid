package com.werockstar.tourandroid.di

import com.werockstar.tourandroid.data.local.KeyValueStorage
import com.werockstar.tourandroid.data.local.LocalStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class LocalStorageModule {
	@Binds
	abstract fun bindLocalStorage(keyValueStorage: KeyValueStorage): LocalStorage
}
