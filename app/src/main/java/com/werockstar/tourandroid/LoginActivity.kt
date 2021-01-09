package com.werockstar.tourandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.werockstar.tourandroid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

	private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		binding.buttonSignIn.setOnClickListener {
			val password = binding.editTextPassword.text.toString()
			val username = binding.editTextUsername.text.toString()

			if (username == "admin" && password == "admin") {

			} else {
				binding.editTextUsername.setText("")
			}
		}

	}
}
