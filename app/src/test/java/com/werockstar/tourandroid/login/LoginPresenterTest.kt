package com.werockstar.tourandroid.login

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
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

		presenter.authenticate("admin", "")

		assertEquals("Ops! something went wrong", view.captureShowWarning)
	}

	@Test
	fun `when password has correct should show warning`() {
		val presenter = LoginPresenter()
		val view = SpyLoginView()

		presenter.attachView(view)

		presenter.authenticate("admin", "admin")

		assertEquals(1, view.captureHomeScreen)
		assertEquals("", view.captureShowWarning)
		assertEquals(0, view.captureResetPassword)
	}
}

class SpyLoginView : LoginPresenter.LoginView {

	var captureHomeScreen = 0
	var captureResetPassword = 0
	var captureShowWarning = ""

	override fun toHomeScreen() {
		captureHomeScreen += 1
	}

	override fun resetPassword() {
		captureResetPassword += 1
	}

	override fun showWarning(message: String) {
		captureShowWarning = message
	}

}
