package com.werockstar.tourandroid.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.werockstar.tourandroid.data.local.LocalStorage
import com.werockstar.tourandroid.data.remote.TourAPI
import com.werockstar.tourandroid.data.remote.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
	private val api: TourAPI,
	private val local: LocalStorage
) : ViewModel() {

	private val _usersLiveData = MutableLiveData<List<User>>()
	val usersLiveData: LiveData<List<User>> = _usersLiveData

	fun getUser() {
		viewModelScope.launch {
			val users = async(Dispatchers.IO) { api.users() }
			try {
				_usersLiveData.value = users.await()
			} catch (e: Exception) {
			}
		}
	}

	fun logout() {
		local.putBoolean("authenticate", false)
	}
}
