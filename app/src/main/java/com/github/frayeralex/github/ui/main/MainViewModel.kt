package com.github.frayeralex.github.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.github.frayeralex.github.db.AppDatabase
import com.github.frayeralex.github.db.ProfileEntity
import com.github.frayeralex.github.repositories.ProfileRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProfileRepository
    var profile = MutableLiveData<ProfileEntity>()

    init {
        val forecastDao = AppDatabase.getDatabase(application).profileDao()
        repository = ProfileRepository(forecastDao)
    }

    fun updateProfile(id: Int) = viewModelScope.launch {
        profile.value = repository.getProfile(id);
    }
}
