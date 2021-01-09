package com.werockstar.tourandroid.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class KeyValueStorage @Inject constructor(private val preferences: SharedPreferences) : LocalStorage {

	override fun getBoolean(key: String): Boolean {
		return preferences.getBoolean(key, false)
	}

	override fun putBoolean(key: String, value: Boolean) {
		preferences.edit().putBoolean(key, value).apply()
	}
}
