package com.werockstar.tourandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.werockstar.tourandroid.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity(R.layout.activity_login) {

	private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val password = binding.editTextPassword.text
		val username = binding.editTextUsername.text
		binding.buttonSignIn.setOnClickListener {

		}

	}
}
