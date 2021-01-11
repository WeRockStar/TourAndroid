package com.werockstar.tourandroid.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class AppDispatcher @Inject constructor(val io: CoroutineDispatcher, val main: CoroutineDispatcher)
