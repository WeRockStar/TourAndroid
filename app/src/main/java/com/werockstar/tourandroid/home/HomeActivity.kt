package com.werockstar.tourandroid.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.werockstar.tourandroid.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: AppCompatActivity() {

	private val viewModel: HomeViewModel by viewModels()

	private val binding: ActivityHomeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		viewModel.getUser()
		viewModel.usersLiveData.observe(this, {
			val adapter = HomeAdapter(it)
			binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
			binding.recyclerView.adapter = adapter
		})
	}
}
