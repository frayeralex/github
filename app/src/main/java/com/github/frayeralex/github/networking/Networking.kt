package com.github.frayeralex.github.networking

import com.github.frayeralex.github.enities.ProfileEntity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Networking private constructor() {

    private val api: Api = Retrofit.Builder().baseUrl(Api.BASE_URL)
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    fun getUserProfile(username: String): Call<ProfileEntity> {
        return api.getUserProfile(username)
    }

    companion object {
        val instance: Networking = Networking()
    }
}