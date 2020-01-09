package com.github.frayeralex.github.repositories

import com.github.frayeralex.github.db.*
import com.github.frayeralex.github.enities.ProfileEntity
import com.github.frayeralex.github.networking.Networking
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ProfileRepository(private val profileDao: ProfileDao) {
    suspend fun getProfile(login: String): ProfileEntity {
        val res: Response<ProfileEntity> = withContext(Dispatchers.IO){
            Networking.instance.getUserProfile(login).execute()
        }
        val profile = res.body()
            if (res.isSuccessful && profile is ProfileEntity) {
                profileDao.insert(profile)
                return profile
            }
        return profileDao.loadByLogin(login)
    }
}