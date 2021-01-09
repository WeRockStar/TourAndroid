package com.werockstar.tourandroid.di

import com.werockstar.tourandroid.data.remote.TourAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class HttpModule {

	@Provides
	fun provideOkHttp(): OkHttpClient {
		val logging = HttpLoggingInterceptor()
		logging.setLevel(HttpLoggingInterceptor.Level.BASIC)

		return OkHttpClient.Builder()
			.addInterceptor(logging)
			.build()
	}

	@Provides
	fun provideRetrofit(client: OkHttpClient): TourAPI {
		return Retrofit.Builder()
			.baseUrl("https://api.github.com/")
			.client(client)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(TourAPI::class.java)
	}
}
