package com.werockstar.tourandroid.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.werockstar.tourandroid.databinding.ActivityHomeBinding
import com.werockstar.tourandroid.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

	private val viewModel: HomeViewModel by viewModels()

	private val binding: ActivityHomeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		viewModel.getUser()
		viewModel.usersLiveData.observe(this, {
			val adapter = HomeAdapter(it) { url ->
				val webPage: Uri = Uri.parse(url)
				val intent = Intent(Intent.ACTION_VIEW, webPage)
				startActivity(intent)
			}
			binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
			binding.recyclerView.adapter = adapter
		})

		binding.ivExit.setOnClickListener {
			viewModel.logout()
			startActivity(Intent(this, LoginActivity::class.java))
			finish()
		}
	}
}
