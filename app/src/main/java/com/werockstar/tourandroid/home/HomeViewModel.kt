package com.werockstar.tourandroid.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
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

	fun getUser() {
		viewModelScope.launch(appDispatcher.main) {
			val users = async(appDispatcher.io) { api.users() }
			_usersLiveData.value = users.await()
		}
	}

	fun logout() = liveData {
		local.putBoolean("authenticate", false)
		emit(Unit)
	}
}
