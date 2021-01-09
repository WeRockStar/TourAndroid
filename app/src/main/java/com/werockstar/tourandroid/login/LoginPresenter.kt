package com.werockstar.tourandroid.login

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
		if (username == "admin" && password == "admin") {
			local.putBoolean("authenticate", true)
			view.toHomeScreen()
		} else {
			local.putBoolean("authenticate", false)
			view.resetPassword()
			view.showWarning("Ops! something went wrong")
		}
	}

}
