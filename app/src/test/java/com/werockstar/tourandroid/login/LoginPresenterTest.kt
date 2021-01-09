package com.werockstar.tourandroid.login

import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LoginPresenterTest {

	@Mock lateinit var view: LoginPresenter.LoginView

	@Before
	fun setUp() {
		MockitoAnnotations.initMocks(this)
	}

	@Test
	fun `when password has invalid should show warning`() {
		val presenter = LoginPresenter()

		presenter.attachView(view)

		val order = Mockito.inOrder(view)
		presenter.authenticate("admin", "")

		order.verify(view, times(1)).resetPassword()
		order.verify(view, times(1)).showWarning("Ops! something went wrong")

		verify(view, never()).toHomeScreen()
	}

	@Test
	fun `when password has correct should show warning`() {
		val presenter = LoginPresenter()
		presenter.attachView(view)

		presenter.authenticate("admin", "admin")

		verify(view, times(1)).toHomeScreen()
		verify(view, never()).resetPassword()
		verify(view, never()).showWarning("Ops! something went wrong")
	}
}
