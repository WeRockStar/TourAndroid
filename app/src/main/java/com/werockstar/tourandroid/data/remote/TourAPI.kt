package com.werockstar.tourandroid.data.remote

import retrofit2.http.GET

interface TourAPI {

	@GET("users")
	suspend fun users(): List<User>
}
