package com.werockstar.tourandroid.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.werockstar.tourandroid.databinding.ActivityLoginBinding
import com.werockstar.tourandroid.presentation.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), LoginPresenter.LoginView {

	@Inject lateinit var presenter: LoginPresenter

	private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		presenter.attachView(this)

		binding.buttonSignIn.setOnClickListener {
			val password = binding.editTextPassword.text.toString()
			val username = binding.editTextUsername.text.toString()
			presenter.authenticate(username, password)
		}

	}

	override fun toHomeScreen() {
		startActivity(Intent(this, HomeActivity::class.java))
		finish()
	}

	override fun showWarning(message: String) {
		Toast.makeText(this, message, Toast.LENGTH_LONG).show()
	}

	override fun resetPassword() {
		binding.editTextPassword.setText("")
	}
}
