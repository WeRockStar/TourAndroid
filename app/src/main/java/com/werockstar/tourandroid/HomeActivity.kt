package com.werockstar.tourandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.werockstar.tourandroid.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity() {

	private val binding: ActivityHomeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)
	}
}
