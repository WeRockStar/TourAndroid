package com.werockstar.tourandroid

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.werockstar.tourandroid.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity(R.layout.activity_splash_screen) {

	private val binding: ActivitySplashScreenBinding by lazy {
		ActivitySplashScreenBinding.inflate(layoutInflater)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		Handler(Looper.getMainLooper())
			.postDelayed({
				startActivity(Intent(this, LoginActivity::class.java))
			}, 3000)
	}
}
