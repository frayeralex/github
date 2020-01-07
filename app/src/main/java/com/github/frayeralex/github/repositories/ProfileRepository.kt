package com.github.frayeralex.github.repositories

import androidx.lifecycle.LiveData
import com.github.frayeralex.github.db.*

class ProfileRepository(private val profileDao: ProfileDao) {
    suspend fun getProfile(id: Int): ProfileEntity {
        return profileDao.loadById(id)
    }

    suspend fun insert(profile: ProfileEntity) {
        profileDao.insert(profile)
    }
}