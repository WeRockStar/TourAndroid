package com.werockstar.tourandroid.splash

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.werockstar.tourandroid.data.local.LocalStorage
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SplashPresenterTest {

	@Mock lateinit var view: SplashPresenter.SplashView
	@Mock lateinit var local: LocalStorage

	@Before
	fun setUp() {
		MockitoAnnotations.initMocks(this)
	}

	@Test
	fun `when user authenticated should go to home screen`() {
		whenever(local.getBoolean("authenticate")).thenReturn(true)

		val presenter = SplashPresenter(local)
		presenter.attachView(view)

		presenter.checkAuthentication()

		verify(view).toHome()
	}

	@Test
	fun `when user unauthorized should go to login screen`() {
		whenever(local.getBoolean("authenticate")).thenReturn(false)

		val presenter = SplashPresenter(local)
		presenter.attachView(view)

		presenter.checkAuthentication()

		verify(view).toLogin()
	}
}
