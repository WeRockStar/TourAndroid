package com.werockstar.tourandroid.splash

import com.werockstar.tourandroid.data.local.LocalStorage
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val local: LocalStorage) {

	private lateinit var view: SplashView

	fun attachView(view: SplashView) {
		this.view = view
	}

	interface SplashView {
		fun toLogin()
		fun toHome()
	}

	fun checkAuthentication() {
		when(local.getBoolean("authenticate")) {
			true -> view.toHome()
			else -> view.toLogin()
		}
	}
}
