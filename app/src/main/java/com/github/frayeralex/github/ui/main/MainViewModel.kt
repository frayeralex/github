package com.github.frayeralex.github.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.github.frayeralex.github.db.AppDatabase
import com.github.frayeralex.github.enities.ProfileEntity
import com.github.frayeralex.github.networking.Networking
import com.github.frayeralex.github.repositories.ProfileRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProfileRepository

    var profile = MutableLiveData<ProfileEntity>()

    init {
        val forecastDao = AppDatabase.getDatabase(application).profileDao()
        repository = ProfileRepository(forecastDao)
    }

    fun updateProfile(login: String) {
        viewModelScope.launch {
            profile.value = repository.getProfile(login);
        }
    }
}
