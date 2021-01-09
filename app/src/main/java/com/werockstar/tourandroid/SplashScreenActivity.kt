package com.werockstar.tourandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.werockstar.tourandroid.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashScreenActivity : AppCompatActivity(), CoroutineScope {

	override val coroutineContext: CoroutineContext get() = Job() + Dispatchers.Main

	private val binding: ActivitySplashScreenBinding by lazy {
		ActivitySplashScreenBinding.inflate(layoutInflater)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		launch {
			delay(3000)
			val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
			startActivity(intent)
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
			finish()
		}

	}

}
