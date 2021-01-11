package com.werockstar.tourandroid.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.werockstar.tourandroid.data.local.LocalStorage
import com.werockstar.tourandroid.data.remote.TourAPI
import com.werockstar.tourandroid.data.remote.User
import com.werockstar.tourandroid.coroutines.AppDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class HomeViewModelTest {

	@Mock lateinit var local: LocalStorage
	@Mock lateinit var api: TourAPI

	@get:Rule val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

	@Before
	fun setUp() {
		MockitoAnnotations.initMocks(this)
	}

	@Test
	fun `when user call logout authenticate flag should be false`() {
		val appDispatcher = AppDispatcher(Dispatchers.Unconfined, Dispatchers.Unconfined)
		val viewModel = HomeViewModel(api, local, appDispatcher)

		viewModel.logout()

		verify(local).putBoolean("authenticate", false)
	}

	@Test
	fun `when user call getUser success should return list of users`() = runBlocking {
		val appDispatcher = AppDispatcher(Dispatchers.Unconfined, Dispatchers.Unconfined)
		val stubUsers =
			listOf(User("werockstar", "https://google.com/image", "https://google.com/image"))
		whenever(api.users()).thenReturn(stubUsers)

		val viewModel = HomeViewModel(api, local, appDispatcher)

		viewModel.getUser()

		val expect =
			listOf(User("werockstar", "https://google.com/image", "https://google.com/image"))
		assertEquals(expect, viewModel.usersLiveData.value)
	}
}
