package com.werockstar.tourandroid.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.werockstar.tourandroid.data.local.LocalStorage
import com.werockstar.tourandroid.data.remote.TourAPI
import com.werockstar.tourandroid.data.remote.User
import com.werockstar.tourandroid.thread.AppDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
	private val api: TourAPI,
	private val local: LocalStorage,
	private val appDispatcher: AppDispatcher
) : ViewModel() {

	private val _usersLiveData = MutableLiveData<List<User>>()
	val usersLiveData: LiveData<List<User>> = _usersLiveData

	private val _logoutLiveData = MutableLiveData<Unit>()
	val logoutLiveData: LiveData<Unit> = _logoutLiveData

	fun getUser() {
		viewModelScope.launch(appDispatcher.main) {
			val users = async(appDispatcher.io) { api.users() }
			_usersLiveData.value = users.await()
		}
	}

	fun logout() {
		local.putBoolean("authenticate", false)
			.run { _logoutLiveData.value = Unit }
	}
}
