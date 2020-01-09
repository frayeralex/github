package com.github.frayeralex.github.db

import androidx.room.*
import com.github.frayeralex.github.enities.ProfileEntity

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile_table WHERE login=:login")
    suspend fun loadByLogin(login: String): ProfileEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profile: ProfileEntity)

    @Delete
    suspend fun delete(profile: ProfileEntity)
}