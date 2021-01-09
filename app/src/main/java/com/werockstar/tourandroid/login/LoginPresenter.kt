package com.werockstar.tourandroid.login

import android.content.Intent
import com.werockstar.tourandroid.home.HomeActivity
import javax.inject.Inject

class LoginPresenter @Inject constructor() {

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
			view.toHomeScreen()
		} else {
			view.resetPassword()
			view.showWarning("Ops! something went wrong")
		}
	}

}
