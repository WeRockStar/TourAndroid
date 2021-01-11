package com.werockstar.tourandroid.presentation.login

import com.werockstar.tourandroid.data.local.LocalStorage
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val local: LocalStorage) {

	private lateinit var view: LoginView

	interface LoginView {
		fun toHomeScreen()
		fun resetPassword()
		fun showWarning(message: String)
	}

	fun attachView(view: LoginView) {
		this.view = view
	}

	fun authenticate(username: String, password: String) {
		val isAuthenticateSuccess = username == "admin" && password == "admin"
		local.putBoolean("authenticate", isAuthenticateSuccess)

		when (isAuthenticateSuccess) {
			true -> view.toHomeScreen()
			false -> {
				view.resetPassword()
				view.showWarning("Ops! something went wrong")
			}
		}
	}

}
