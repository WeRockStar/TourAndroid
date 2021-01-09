package com.werockstar.tourandroid.data.local

interface LocalStorage {
	fun getBoolean(key: String): Boolean
	fun putBoolean(key: String, value: Boolean)
}
