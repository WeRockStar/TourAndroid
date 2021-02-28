package com.werockstar.tourandroid.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.werockstar.tourandroid.databinding.ActivitySplashScreenBinding
import com.werockstar.tourandroid.presentation.home.HomeActivity
import com.werockstar.tourandroid.presentation.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity(), CoroutineScope, SplashPresenter.SplashView {

	override val coroutineContext: CoroutineContext get() = Job() + Dispatchers.Main

	@Inject lateinit var presenter: SplashPresenter

	private val binding: ActivitySplashScreenBinding by lazy {
		ActivitySplashScreenBinding.inflate(layoutInflater)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
		presenter.attachView(this)

		launch {
			delay(3000)
			presenter.checkAuthentication()
		}

	}

	override fun toLogin() {
		val intent = Intent(this, LoginActivity::class.java)
		startActivity(intent)
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
		finish()
	}

	override fun toHome() {
		val intent = Intent(this, HomeActivity::class.java)
		startActivity(intent)
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
		finish()
	}

}
