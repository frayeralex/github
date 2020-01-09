package com.github.frayeralex.github.networking

import com.github.frayeralex.github.enities.ProfileEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("users/{username}")
    fun getUserProfile(@Path("username") username: String): Call<ProfileEntity>

    companion object {
        const val BASE_URL = "https://api.github.com"
    }
}