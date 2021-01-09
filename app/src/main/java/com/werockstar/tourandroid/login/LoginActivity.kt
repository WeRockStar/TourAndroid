package com.werockstar.tourandroid.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.werockstar.tourandroid.databinding.ActivityLoginBinding
import com.werockstar.tourandroid.home.HomeActivity

class LoginActivity : AppCompatActivity() {

	private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		binding.buttonSignIn.setOnClickListener {
			val password = binding.editTextPassword.text.toString()
			val username = binding.editTextUsername.text.toString()

			if (username == "admin" && password == "admin") {
				startActivity(Intent(this, HomeActivity::class.java))
				finish()
			} else {
				binding.editTextPassword.setText("")
			}
		}

	}
}
