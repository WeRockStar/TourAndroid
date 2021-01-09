package com.werockstar.tourandroid.data.remote

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("login") val user: String, @SerializedName("avatar_url") val url: String)
